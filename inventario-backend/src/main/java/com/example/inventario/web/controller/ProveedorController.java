package com.example.inventario.web.controller;

import com.example.inventario.service.ProveedorService;
import com.example.inventario.web.dto.ProveedorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
// @RequiredArgsConstructor // Removed Lombok annotation
@Tag(name = "Proveedores", description = "API para la gestión de proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @Autowired // Explicitly inject dependencies via constructor
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @Operation(summary = "Obtener una lista de todos los proveedores")
    @GetMapping
    public ResponseEntity<List<ProveedorDto>> getAll() {
        return ResponseEntity.ok(proveedorService.findAll());
    }
}
