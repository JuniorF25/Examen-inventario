package com.example.inventario.web.controller;

import com.example.inventario.service.BodegaService;
import com.example.inventario.web.dto.BodegaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bodegas")
// @RequiredArgsConstructor // Removed Lombok annotation
@Tag(name = "Bodegas", description = "API para la gestión de bodegas")
public class BodegaController {

    private final BodegaService bodegaService;

    @Autowired // Explicitly inject dependencies via constructor
    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    @Operation(summary = "Obtener una lista de todas las bodegas")
    @GetMapping
    public ResponseEntity<List<BodegaDto>> getAll() {
        return ResponseEntity.ok(bodegaService.findAll());
    }
}
