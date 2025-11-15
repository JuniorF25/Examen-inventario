package com.example.inventario.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ProductoDto {
    private Long id;
    private String sku;
    private String nombre;
    private String descripcion;
    private String unidadMedida;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private boolean activo;
    private LocalDateTime creadoEn;

    // No-argument constructor
    public ProductoDto() {
    }

    // All-argument constructor
    public ProductoDto(Long id, String sku, String nombre, String descripcion, String unidadMedida, BigDecimal precioCompra, BigDecimal precioVenta, boolean activo, LocalDateTime creadoEn) {
        this.id = id;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.activo = activo;
        this.creadoEn = creadoEn;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public boolean isActivo() {
        return activo;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoDto that = (ProductoDto) o;
        return activo == that.activo &&
               Objects.equals(id, that.id) &&
               Objects.equals(sku, that.sku) &&
               Objects.equals(nombre, that.nombre) &&
               Objects.equals(descripcion, that.descripcion) &&
               Objects.equals(unidadMedida, that.unidadMedida) &&
               Objects.equals(precioCompra, that.precioCompra) &&
               Objects.equals(precioVenta, that.precioVenta) &&
               Objects.equals(creadoEn, that.creadoEn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, nombre, descripcion, unidadMedida, precioCompra, precioVenta, activo, creadoEn);
    }

    @Override
    public String toString() {
        return String.format("ProductoDto{id=%d, sku='%s', nombre='%s', descripcion='%s', unidadMedida='%s', precioCompra=%s, precioVenta=%s, activo=%b, creadoEn=%s}",
                             id, sku, nombre, descripcion, unidadMedida, precioCompra, precioVenta, activo, creadoEn);
    }
}