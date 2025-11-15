package com.example.inventario.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "inventario", uniqueConstraints = {
    @UniqueConstraint(name = "uk_inventario_producto_bodega", columnNames = {"producto_id", "bodega_id"})
})
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bodega_id", nullable = false)
    private Bodega bodega;

    @Column(nullable = false)
    private int cantidad;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    // No-argument constructor
    public Inventario() {
    }

    // All-argument constructor (excluding id and lastUpdated for builder-like usage)
    public Inventario(Producto producto, Bodega bodega, int cantidad) {
        this.producto = producto;
        this.bodega = bodega;
        this.cantidad = cantidad;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public Bodega getBodega() {
        return bodega;
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

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
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
        Inventario that = (Inventario) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Inventario{" +
               "id=" + id +
               ", producto=" + (producto != null ? producto.getId() : "null") + // Avoid infinite loop
               ", bodega=" + (bodega != null ? bodega.getId() : "null") + // Avoid infinite loop
               ", cantidad=" + cantidad +
               ", lastUpdated=" + lastUpdated +
               '}';
    }
}