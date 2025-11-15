package com.example.inventario.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class MovimientoDto {
    private Long id;
    private LocalDateTime fecha;
    private char tipo;
    private Long productoId;
    private String productoSku;
    private String productoNombre;
    private Long bodegaId;
    private String bodegaNombre;
    private Long proveedorId;
    private String proveedorNombre;
    private int cantidad;
    private BigDecimal costoUnitario;
    private BigDecimal precioUnitario;
    private String referencia;
    private String notas;

    // No-argument constructor
    public MovimientoDto() {
    }

    // All-argument constructor
    public MovimientoDto(Long id, LocalDateTime fecha, char tipo, Long productoId, String productoSku, String productoNombre, Long bodegaId, String bodegaNombre, Long proveedorId, String proveedorNombre, int cantidad, BigDecimal costoUnitario, BigDecimal precioUnitario, String referencia, String notas) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.productoId = productoId;
        this.productoSku = productoSku;
        this.productoNombre = productoNombre;
        this.bodegaId = bodegaId;
        this.bodegaNombre = bodegaNombre;
        this.proveedorId = proveedorId;
        this.proveedorNombre = proveedorNombre;
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

    public Long getProveedorId() {
        return proveedorId;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
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

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
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
        MovimientoDto that = (MovimientoDto) o;
        return tipo == that.tipo &&
               cantidad == that.cantidad &&
               Objects.equals(id, that.id) &&
               Objects.equals(fecha, that.fecha) &&
               Objects.equals(productoId, that.productoId) &&
               Objects.equals(productoSku, that.productoSku) &&
               Objects.equals(productoNombre, that.productoNombre) &&
               Objects.equals(bodegaId, that.bodegaId) &&
               Objects.equals(bodegaNombre, that.bodegaNombre) &&
               Objects.equals(proveedorId, that.proveedorId) &&
               Objects.equals(proveedorNombre, that.proveedorNombre) &&
               Objects.equals(costoUnitario, that.costoUnitario) &&
               Objects.equals(precioUnitario, that.precioUnitario) &&
               Objects.equals(referencia, that.referencia) &&
               Objects.equals(notas, that.notas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, tipo, productoId, productoSku, productoNombre, bodegaId, bodegaNombre, proveedorId, proveedorNombre, cantidad, costoUnitario, precioUnitario, referencia, notas);
    }

    @Override
    public String toString() {
        return "MovimientoDto{"
               + "id=" + id +
               ", fecha=" + fecha +
               ", tipo=" + tipo +
               ", productoId=" + productoId +
               ", productoSku='" + productoSku + '\'' +
               ", productoNombre='" + productoNombre + '\'' +
               ", bodegaId=" + bodegaId +
               ", bodegaNombre='" + bodegaNombre + '\'' +
               ", proveedorId=" + proveedorId +
               ", proveedorNombre='" + proveedorNombre + '\'' +
               ", cantidad=" + cantidad +
               ", costoUnitario=" + costoUnitario +
               ", precioUnitario=" + precioUnitario +
               ", referencia='" + referencia + '\'' +
               ", notas='" + notas + '\'' +
               '}';
    }
}