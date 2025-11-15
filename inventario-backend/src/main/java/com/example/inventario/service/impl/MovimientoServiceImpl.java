package com.example.inventario.service.impl;

import com.example.inventario.domain.*;
import com.example.inventario.repository.*;
import com.example.inventario.service.MovimientoService;
import com.example.inventario.web.dto.CrearMovimientoEntradaRequest;
import com.example.inventario.web.dto.CrearMovimientoSalidaRequest;
import com.example.inventario.web.dto.MovimientoDto;
import com.example.inventario.web.exception.InsufficientStockException;
import com.example.inventario.web.exception.ResourceNotFoundException;
import com.example.inventario.web.mapper.MovimientoMapper;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final InventarioRepository inventarioRepository;
    private final ProductoRepository productoRepository;
    private final BodegaRepository bodegaRepository;
    private final ProveedorRepository proveedorRepository;
    private final MovimientoMapper movimientoMapper;

    @Autowired // Explicitly inject dependencies via constructor
    public MovimientoServiceImpl(MovimientoRepository movimientoRepository,
                                 InventarioRepository inventarioRepository,
                                 ProductoRepository productoRepository,
                                 BodegaRepository bodegaRepository,
                                 ProveedorRepository proveedorRepository,
                                 MovimientoMapper movimientoMapper) {
        this.movimientoRepository = movimientoRepository;
        this.inventarioRepository = inventarioRepository;
        this.productoRepository = productoRepository;
        this.bodegaRepository = bodegaRepository;
        this.proveedorRepository = proveedorRepository;
        this.movimientoMapper = movimientoMapper;
    }

    @Override
    @Transactional
    public MovimientoDto registrarEntrada(CrearMovimientoEntradaRequest request) {
        Producto producto = findProducto(request.getProductoId());
        Bodega bodega = findBodega(request.getBodegaId());
        Proveedor proveedor = findProveedor(request.getProveedorId());

        // Upsert de Inventario con bloqueo pesimista
        Inventario inventario = inventarioRepository.findByProductoIdAndBodegaIdForUpdate(producto.getId(), bodega.getId())
                .orElseGet(() -> {
                    Inventario nuevoInventario = new Inventario();
                    nuevoInventario.setProducto(producto);
                    nuevoInventario.setBodega(bodega);
                    nuevoInventario.setCantidad(0);
                    return nuevoInventario;
                });

        inventario.setCantidad(inventario.getCantidad() + request.getCantidad());
        inventarioRepository.save(inventario);

        Movimiento movimiento = movimientoMapper.toEntity(request);
        movimiento.setProducto(producto);
        movimiento.setBodega(bodega);
        movimiento.setProveedor(proveedor);
        movimiento.setFecha(Optional.ofNullable(request.getFecha()).orElse(LocalDateTime.now()));

        Movimiento savedMovimiento = movimientoRepository.save(movimiento);
        return movimientoMapper.toDto(savedMovimiento);
    }

    @Override
    @Transactional
    public MovimientoDto registrarSalida(CrearMovimientoSalidaRequest request) {
        Producto producto = findProducto(request.getProductoId());
        Bodega bodega = findBodega(request.getBodegaId());

        // Bloqueo pesimista para la actualización
        Inventario inventario = inventarioRepository.findByProductoIdAndBodegaIdForUpdate(producto.getId(), bodega.getId())
                .orElseThrow(() -> new InsufficientStockException("No hay stock del producto " + producto.getSku() + " en la bodega " + bodega.getNombre()));

        if (inventario.getCantidad() < request.getCantidad()) {
            throw new InsufficientStockException("Stock insuficiente para el producto " + producto.getSku() + ". Stock actual: " + inventario.getCantidad() + ", solicitado: " + request.getCantidad());
        }

        inventario.setCantidad(inventario.getCantidad() - request.getCantidad());
        inventarioRepository.save(inventario);

        Movimiento movimiento = movimientoMapper.toEntity(request);
        movimiento.setProducto(producto);
        movimiento.setBodega(bodega);
        movimiento.setFecha(Optional.ofNullable(request.getFecha()).orElse(LocalDateTime.now()));

        Movimiento savedMovimiento = movimientoRepository.save(movimiento);
        return movimientoMapper.toDto(savedMovimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MovimientoDto> findByFilters(Long productoId, Character tipo, LocalDate desde, LocalDate hasta, Pageable pageable) {
        Specification<Movimiento> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (productoId != null) {
                predicates.add(cb.equal(root.get("producto").get("id"), productoId));
            }
            if (tipo != null) {
                predicates.add(cb.equal(root.get("tipo"), tipo));
            }
            if (desde != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("fecha"), desde.atStartOfDay()));
            }
            if (hasta != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("fecha"), hasta.atTime(23, 59, 59)));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return movimientoRepository.findAll(spec, pageable).map(movimientoMapper::toDto);
    }

    private Producto findProducto(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
    }

    private Bodega findBodega(Long id) {
        return bodegaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bodega no encontrada con ID: " + id));
    }

    private Proveedor findProveedor(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado con ID: " + id));
    }
}