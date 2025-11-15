package com.example.inventario.web.controller;

import com.example.inventario.service.MovimientoService;
import com.example.inventario.web.dto.CrearMovimientoEntradaRequest;
import com.example.inventario.web.dto.CrearMovimientoSalidaRequest;
import com.example.inventario.web.dto.MovimientoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/movimientos")
// @RequiredArgsConstructor // Removed Lombok annotation
@Tag(name = "Movimientos", description = "API para la gestión de movimientos de inventario")
public class MovimientoController {

    private final MovimientoService movimientoService;

    @Autowired // Explicitly inject dependencies via constructor
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @Operation(summary = "Registrar una entrada de inventario")
    @PostMapping("/entrada")
    public ResponseEntity<MovimientoDto> registerEntry(@Valid @RequestBody CrearMovimientoEntradaRequest request) {
        MovimientoDto movimiento = movimientoService.registrarEntrada(request);
        return new ResponseEntity<>(movimiento, HttpStatus.CREATED);
    }

    @Operation(summary = "Registrar una salida de inventario")
    @PostMapping("/salida")
    public ResponseEntity<MovimientoDto> registerExit(@Valid @RequestBody CrearMovimientoSalidaRequest request) {
        MovimientoDto movimiento = movimientoService.registrarSalida(request);
        return new ResponseEntity<>(movimiento, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener el historial de movimientos con filtros")
    @GetMapping
    public ResponseEntity<Page<MovimientoDto>> getHistory(
            @RequestParam(required = false) Long productoId,
            @RequestParam(required = false) Character tipo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta,
            Pageable pageable) {
        return ResponseEntity.ok(movimientoService.findByFilters(productoId, tipo, desde, hasta, pageable));
    }
}
