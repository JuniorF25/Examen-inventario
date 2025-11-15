package com.example.inventario.service;

import com.example.inventario.web.dto.InventarioDto;
import com.example.inventario.web.dto.InventarioTotalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InventarioService {
    Page<InventarioDto> findByFilters(Long productoId, Long bodegaId, Pageable pageable);
    Page<InventarioTotalDto> findTotales(Pageable pageable);
}
