package com.example.inventario.web.controller;

import com.example.inventario.service.ProductoService;
import com.example.inventario.web.dto.CrearProductoRequest;
import com.example.inventario.web.dto.ProductoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
// @RequiredArgsConstructor // Removed Lombok annotation
@Tag(name = "Productos", description = "API para la gestión de productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired // Explicitly inject dependencies via constructor
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Obtener una lista paginada de productos")
    @GetMapping
    public ResponseEntity<Page<ProductoDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(productoService.findAll(pageable));
    }

    @Operation(summary = "Obtener un producto por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.findById(id));
    }

    @Operation(summary = "Crear un nuevo producto")
    @PostMapping
    public ResponseEntity<ProductoDto> create(@Valid @RequestBody CrearProductoRequest request) {
        ProductoDto createdProducto = productoService.create(request);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }
}
