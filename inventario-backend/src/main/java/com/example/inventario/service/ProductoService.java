package com.example.inventario.service;

import com.example.inventario.web.dto.CrearProductoRequest;
import com.example.inventario.web.dto.ProductoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {
    ProductoDto create(CrearProductoRequest request);
    ProductoDto findById(Long id);
    Page<ProductoDto> findAll(Pageable pageable);
}
