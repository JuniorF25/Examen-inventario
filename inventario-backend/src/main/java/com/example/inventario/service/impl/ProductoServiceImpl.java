package com.example.inventario.service.impl;

import com.example.inventario.domain.Producto;
import com.example.inventario.repository.ProductoRepository;
import com.example.inventario.service.ProductoService;
import com.example.inventario.web.dto.CrearProductoRequest;
import com.example.inventario.web.dto.ProductoDto;
import com.example.inventario.web.exception.ResourceNotFoundException;
import com.example.inventario.web.mapper.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Autowired // Explicitly inject dependencies via constructor
    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    @Transactional
    public ProductoDto create(CrearProductoRequest request) {
        Producto producto = productoMapper.toEntity(request);
        Producto savedProducto = productoRepository.save(producto);
        return productoMapper.toDto(savedProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDto findById(Long id) {
        return productoRepository.findById(id)
                .map(productoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductoDto> findAll(Pageable pageable) {
        return productoRepository.findAll(pageable)
                .map(productoMapper::toDto);
    }
}