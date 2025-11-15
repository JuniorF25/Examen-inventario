package com.example.inventario.web.controller;

import com.example.inventario.service.InventarioService;
import com.example.inventario.web.dto.InventarioDto;
import com.example.inventario.web.dto.InventarioTotalDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventario")
// @RequiredArgsConstructor // Removed Lombok annotation
@Tag(name = "Inventario", description = "API para la consulta de inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    @Autowired // Explicitly inject dependencies via constructor
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @Operation(summary = "Obtener el estado del inventario con filtros opcionales")
    @GetMapping
    public ResponseEntity<Page<InventarioDto>> getByFilters(
            @RequestParam(required = false) Long productoId,
            @RequestParam(required = false) Long bodegaId,
            Pageable pageable) {
        return ResponseEntity.ok(inventarioService.findByFilters(productoId, bodegaId, pageable));
    }

    @Operation(summary = "Obtener los totales de inventario por producto")
    @GetMapping("/totales")
    public ResponseEntity<Page<InventarioTotalDto>> getTotals(Pageable pageable) {
        return ResponseEntity.ok(inventarioService.findTotales(pageable));
    }
}
