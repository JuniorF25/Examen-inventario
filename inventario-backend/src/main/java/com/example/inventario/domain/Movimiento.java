package com.example.inventario.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, length = 1)
    private char tipo; // 'E' para Entrada, 'S' para Salida

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bodega_id", nullable = false)
    private Bodega bodega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id") // Nullable for salidas
    private Proveedor proveedor;

    @Column(nullable = false)
    private int cantidad;

    @Column(name = "costo_unitario", precision = 10, scale = 2) // Not null for entradas
    private BigDecimal costoUnitario;

    @Column(name = "precio_unitario", precision = 10, scale = 2) // Not null for salidas
    private BigDecimal precioUnitario;

    @Column(length = 100)
    private String referencia;

    @Column(columnDefinition = "TEXT")
    private String notas;

    // No-argument constructor
    public Movimiento() {
    }

    // All-argument constructor (excluding id for builder-like usage)
    public Movimiento(LocalDateTime fecha, char tipo, Producto producto, Bodega bodega, Proveedor proveedor, int cantidad, BigDecimal costoUnitario, BigDecimal precioUnitario, String referencia, String notas) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.producto = producto;
        this.bodega = bodega;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.precioUnitario = precioUnitario;
        this.referencia = referencia;
        this.notas = notas;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public char getTipo() {
        return tipo;
    }

    public Producto getProducto() {
        return producto;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNotas() {
        return notas;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento that = (Movimiento) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Movimiento{" +
               "id=" + id +
               ", fecha=" + fecha +
               ", tipo=" + tipo +
               ", producto=" + (producto != null ? producto.getId() : "null") +
               ", bodega=" + (bodega != null ? bodega.getId() : "null") +
               ", proveedor=" + (proveedor != null ? proveedor.getId() : "null") +
               ", cantidad=" + cantidad +
               ", costoUnitario=" + costoUnitario +
               ", precioUnitario=" + precioUnitario +
               ", referencia='" + referencia + "'" +
               ", notas='" + notas + "'" +
               '}';
    }
}