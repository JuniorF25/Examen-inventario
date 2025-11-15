package com.example.inventario.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CrearMovimientoEntradaRequest {

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productoId;

    @NotNull(message = "El ID de la bodega es obligatorio")
    private Long bodegaId;

    @NotNull(message = "El ID del proveedor es obligatorio para las entradas")
    private Long proveedorId;

    @Positive(message = "La cantidad debe ser un número positivo")
    private int cantidad;

    @NotNull(message = "El costo unitario es obligatorio para las entradas")
    @PositiveOrZero(message = "El costo unitario debe ser un valor positivo o cero")
    private BigDecimal costoUnitario;

    private String referencia;
    private String notas;
    private LocalDateTime fecha; // Opcional

    // No-argument constructor
    public CrearMovimientoEntradaRequest() {
    }

    // All-argument constructor
    public CrearMovimientoEntradaRequest(
            @NotNull(message = "El ID del producto es obligatorio") Long productoId,
            @NotNull(message = "El ID de la bodega es obligatorio") Long bodegaId,
            @NotNull(message = "El ID del proveedor es obligatorio para las entradas") Long proveedorId,
            @Positive(message = "La cantidad debe ser un número positivo") int cantidad,
            @NotNull(message = "El costo unitario es obligatorio para las entradas") @PositiveOrZero(message = "El costo unitario debe ser un valor positivo o cero") BigDecimal costoUnitario,
            String referencia, String notas, LocalDateTime fecha) {
        this.productoId = productoId;
        this.bodegaId = bodegaId;
        this.proveedorId = proveedorId;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.referencia = referencia;
        this.notas = notas;
        this.fecha = fecha;
    }

    // Getters
    public Long getProductoId() {
        return productoId;
    }

    public Long getBodegaId() {
        return bodegaId;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNotas() {
        return notas;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    // Setters
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public void setBodegaId(Long bodegaId) {
        this.bodegaId = bodegaId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrearMovimientoEntradaRequest that = (CrearMovimientoEntradaRequest) o;
        return cantidad == that.cantidad &&
               Objects.equals(productoId, that.productoId) &&
               Objects.equals(bodegaId, that.bodegaId) &&
               Objects.equals(proveedorId, that.proveedorId) &&
               Objects.equals(costoUnitario, that.costoUnitario) &&
               Objects.equals(referencia, that.referencia) &&
               Objects.equals(notas, that.notas) &&
               Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, bodegaId, proveedorId, cantidad, costoUnitario, referencia, notas, fecha);
    }

    @Override
    public String toString() {
        return "CrearMovimientoEntradaRequest{"
               + "productoId=" + productoId +
               ", bodegaId=" + bodegaId +
               ", proveedorId=" + proveedorId +
               ", cantidad=" + cantidad +
               ", costoUnitario=" + costoUnitario +
               ", referencia='" + referencia + '\'' +
               ", notas='" + notas + '\'' +
               ", fecha=" + fecha +
               '}';
    }
}