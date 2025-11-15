package com.example.inventario.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "productos_proveedores")
public class ProductoProveedor {

    @EmbeddedId
    private ProductoProveedorId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("proveedorId")
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @Column(name = "codigo_proveedor", length = 50)
    private String codigoProveedor;

    @Column(name = "es_preferido", nullable = false)
    private boolean esPreferido = false; // Default value

    // No-argument constructor
    public ProductoProveedor() {
    }

    // All-argument constructor (excluding id for builder-like usage)
    public ProductoProveedor(ProductoProveedorId id, Producto producto, Proveedor proveedor, String codigoProveedor, boolean esPreferido) {
        this.id = id;
        this.producto = producto;
        this.proveedor = proveedor;
        this.codigoProveedor = codigoProveedor;
        this.esPreferido = esPreferido;
    }

    // Getters
    public ProductoProveedorId getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public boolean isEsPreferido() {
        return esPreferido;
    }

    // Setters
    public void setId(ProductoProveedorId id) {
        this.id = id;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public void setEsPreferido(boolean esPreferido) {
        this.esPreferido = esPreferido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoProveedor that = (ProductoProveedor) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductoProveedor{"
               + "id=" + id +
               ", producto=" + (producto != null ? producto.getId() : "null") +
               ", proveedor=" + (proveedor != null ? proveedor.getId() : "null") +
               ", codigoProveedor='" + codigoProveedor + "'"
               + ", esPreferido=" + esPreferido +
               '}';
    }
}