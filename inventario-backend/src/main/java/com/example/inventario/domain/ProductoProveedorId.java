package com.example.inventario.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductoProveedorId implements Serializable {

    @Column(name = "producto_id")
    private Long productoId;

    @Column(name = "proveedor_id")
    private Long proveedorId;

    // No-argument constructor
    public ProductoProveedorId() {
    }

    // All-argument constructor
    public ProductoProveedorId(Long productoId, Long proveedorId) {
        this.productoId = productoId;
        this.proveedorId = proveedorId;
    }

    // Getters
    public Long getProductoId() {
        return productoId;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    // Setters
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoProveedorId that = (ProductoProveedorId) o;
        return Objects.equals(productoId, that.productoId) && Objects.equals(proveedorId, that.proveedorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, proveedorId);
    }

    @Override
    public String toString() {
        return "ProductoProveedorId{" +
               "productoId=" + productoId +
               ", proveedorId=" + proveedorId +
               '}';
    }
}