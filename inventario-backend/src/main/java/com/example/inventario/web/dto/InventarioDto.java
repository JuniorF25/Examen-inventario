package com.example.inventario.web.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class InventarioDto {
    private Long id;
    private Long productoId;
    private String productoSku;
    private String productoNombre;
    private Long bodegaId;
    private String bodegaNombre;
    private int cantidad;
    private LocalDateTime lastUpdated;

    // No-argument constructor
    public InventarioDto() {
    }

    // All-argument constructor
    public InventarioDto(Long id, Long productoId, String productoSku, String productoNombre, Long bodegaId, String bodegaNombre, int cantidad, LocalDateTime lastUpdated) {
        this.id = id;
        this.productoId = productoId;
        this.productoSku = productoSku;
        this.productoNombre = productoNombre;
        this.bodegaId = bodegaId;
        this.bodegaNombre = bodegaNombre;
        this.cantidad = cantidad;
        this.lastUpdated = lastUpdated;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public String getProductoSku() {
        return productoSku;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public Long getBodegaId() {
        return bodegaId;
    }

    public String getBodegaNombre() {
        return bodegaNombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public void setProductoSku(String productoSku) {
        this.productoSku = productoSku;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public void setBodegaId(Long bodegaId) {
        this.bodegaId = bodegaId;
    }

    public void setBodegaNombre(String bodegaNombre) {
        this.bodegaNombre = bodegaNombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventarioDto that = (InventarioDto) o;
        return cantidad == that.cantidad &&
               Objects.equals(id, that.id) &&
               Objects.equals(productoId, that.productoId) &&
               Objects.equals(productoSku, that.productoSku) &&
               Objects.equals(productoNombre, that.productoNombre) &&
               Objects.equals(bodegaId, that.bodegaId) &&
               Objects.equals(bodegaNombre, that.bodegaNombre) &&
               Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productoId, productoSku, productoNombre, bodegaId, bodegaNombre, cantidad, lastUpdated);
    }

    @Override
    public String toString() {
        return "InventarioDto{"
               + "id=" + id + 
               ", productoId=" + productoId + 
               ", productoSku='" + productoSku + "'" + 
               ", productoNombre='" + productoNombre + "'" + 
               ", bodegaId=" + bodegaId + 
               ", bodegaNombre='" + bodegaNombre + "'" + 
               ", cantidad=" + cantidad + 
               ", lastUpdated=" + lastUpdated + 
               '}';
    }
}