package com.example.inventario.web.dto;

import java.util.Objects;

public class InventarioTotalDto {
    private Long productoId;
    private String productoSku;
    private String productoNombre;
    private long cantidadTotal;

    // No-argument constructor
    public InventarioTotalDto() {
    }

    // All-argument constructor
    public InventarioTotalDto(Long productoId, String productoSku, String productoNombre, long cantidadTotal) {
        this.productoId = productoId;
        this.productoSku = productoSku;
        this.productoNombre = productoNombre;
        this.cantidadTotal = cantidadTotal;
    }

    // Getters
    public Long getProductoId() {
        return productoId;
    }

    public String getProductoSku() {
        return productoSku;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public long getCantidadTotal() {
        return cantidadTotal;
    }

    // Setters
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public void setProductoSku(String productoSku) {
        this.productoSku = productoSku;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public void setCantidadTotal(long cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventarioTotalDto that = (InventarioTotalDto) o;
        return cantidadTotal == that.cantidadTotal &&
               Objects.equals(productoId, that.productoId) &&
               Objects.equals(productoSku, that.productoSku) &&
               Objects.equals(productoNombre, that.productoNombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, productoSku, productoNombre, cantidadTotal);
    }

    @Override
    public String toString() {
        return "InventarioTotalDto{"
               + "productoId=" + productoId + 
               ", productoSku='" + productoSku + "'" +
               ", productoNombre='" + productoNombre + "'" +
               ", cantidadTotal=" + cantidadTotal + 
               '}';
    }
}