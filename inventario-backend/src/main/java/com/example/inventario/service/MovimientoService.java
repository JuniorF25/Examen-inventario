package com.example.inventario.service;

import com.example.inventario.web.dto.CrearMovimientoEntradaRequest;
import com.example.inventario.web.dto.CrearMovimientoSalidaRequest;
import com.example.inventario.web.dto.MovimientoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface MovimientoService {

    MovimientoDto registrarEntrada(CrearMovimientoEntradaRequest request);

    MovimientoDto registrarSalida(CrearMovimientoSalidaRequest request);

    Page<MovimientoDto> findByFilters(Long productoId, Character tipo, LocalDate desde, LocalDate hasta, Pageable pageable);
}
