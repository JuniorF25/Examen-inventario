package com.example.inventario.service.impl;

import com.example.inventario.domain.Inventario;
import com.example.inventario.repository.InventarioRepository;
import com.example.inventario.service.InventarioService;
import com.example.inventario.web.dto.InventarioDto;
import com.example.inventario.web.dto.InventarioTotalDto;
import com.example.inventario.web.mapper.InventarioMapper;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;
    private final InventarioMapper inventarioMapper;

    @Autowired // Explicitly inject dependencies via constructor
    public InventarioServiceImpl(InventarioRepository inventarioRepository, InventarioMapper inventarioMapper) {
        this.inventarioRepository = inventarioRepository;
        this.inventarioMapper = inventarioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InventarioDto> findByFilters(Long productoId, Long bodegaId, Pageable pageable) {
        Specification<Inventario> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (productoId != null) {
                predicates.add(cb.equal(root.get("producto").get("id"), productoId));
            }
            if (bodegaId != null) {
                predicates.add(cb.equal(root.get("bodega").get("id"), bodegaId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return inventarioRepository.findAll(spec, pageable).map(inventarioMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InventarioTotalDto> findTotales(Pageable pageable) {
        return inventarioRepository.findTotalesPorProducto(pageable);
    }
}