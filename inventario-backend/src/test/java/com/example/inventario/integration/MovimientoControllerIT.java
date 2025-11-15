package com.example.inventario.integration;

import com.example.inventario.repository.InventarioRepository;
import com.example.inventario.web.dto.CrearMovimientoEntradaRequest;
import com.example.inventario.web.dto.CrearMovimientoSalidaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class MovimientoControllerIT extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Test
    void registrarEntrada_debeIncrementarStock() throws Exception {
        // Given: An entry request for a product that exists from the seed data (Producto ID 1)
        CrearMovimientoEntradaRequest request = new CrearMovimientoEntradaRequest();
        request.setProductoId(1L);
        request.setBodegaId(1L);
        request.setProveedorId(1L);
        request.setCantidad(5);
        request.setCostoUnitario(new BigDecimal("1450.00"));

        // When: The POST request is made
        mockMvc.perform(post("/api/movimientos/entrada")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cantidad").value(5));

        // Then: The stock in the database should be updated
        // Initial stock from seed: 10 laptops - 2 sold = 8. New stock should be 8 + 5 = 13.
        var inventario = inventarioRepository.findByProductoIdAndBodegaId(1L, 1L).orElseThrow();
        assertThat(inventario.getCantidad()).isEqualTo(13);
    }

    @Test
    void registrarSalida_conStockSuficiente_debeDecrementarStock() throws Exception {
        // Given: An exit request for a product with enough stock (Producto ID 2)
        // Initial stock from seed: 20 monitors - 5 sold = 15.
        CrearMovimientoSalidaRequest request = new CrearMovimientoSalidaRequest();
        request.setProductoId(2L);
        request.setBodegaId(1L);
        request.setCantidad(10);
        request.setPrecioUnitario(new BigDecimal("450.00"));

        // When: The POST request is made
        mockMvc.perform(post("/api/movimientos/salida")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cantidad").value(10));

        // Then: The stock in the database should be updated
        // New stock should be 15 - 10 = 5.
        var inventario = inventarioRepository.findByProductoIdAndBodegaId(2L, 1L).orElseThrow();
        assertThat(inventario.getCantidad()).isEqualTo(5);
    }

    @Test
    void registrarSalida_conStockInsuficiente_debeRetornar409() throws Exception {
        // Given: An exit request for more items than are in stock (Producto ID 1)
        // Initial stock from seed: 10 laptops - 2 sold = 8. Requesting 9.
        CrearMovimientoSalidaRequest request = new CrearMovimientoSalidaRequest();
        request.setProductoId(1L);
        request.setBodegaId(1L);
        request.setCantidad(9); // More than available stock
        request.setPrecioUnitario(new BigDecimal("2500.00"));

        // When & Then: The POST request is made and a 409 Conflict is expected
        mockMvc.perform(post("/api/movimientos/salida")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value("Stock insuficiente para el producto LAP-MAC-M3. Stock actual: 8, solicitado: 9"));
    }
}
