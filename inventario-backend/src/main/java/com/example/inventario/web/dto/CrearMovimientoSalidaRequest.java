package com.example.inventario.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CrearMovimientoSalidaRequest {

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productoId;

    @NotNull(message = "El ID de la bodega es obligatorio")
    private Long bodegaId;

    @Positive(message = "La cantidad debe ser un número positivo")
    private int cantidad;

    @PositiveOrZero(message = "El precio unitario debe ser un valor positivo o cero")
    private BigDecimal precioUnitario;

    private String referencia;
    private String notas;
    private LocalDateTime fecha; // Opcional

    // No-argument constructor
    public CrearMovimientoSalidaRequest() {
    }

    // All-argument constructor
    public CrearMovimientoSalidaRequest(
            @NotNull(message = "El ID del producto es obligatorio") Long productoId,
            @NotNull(message = "El ID de la bodega es obligatorio") Long bodegaId,
            @Positive(message = "La cantidad debe ser un número positivo") int cantidad,
            @PositiveOrZero(message = "El precio unitario debe ser un valor positivo o cero") BigDecimal precioUnitario,
            String referencia, String notas, LocalDateTime fecha) {
        this.productoId = productoId;
        this.bodegaId = bodegaId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
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

    public int getCantidad() {
        return cantidad;
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrearMovimientoSalidaRequest that = (CrearMovimientoSalidaRequest) o;
        return cantidad == that.cantidad &&
               Objects.equals(productoId, that.productoId) &&
               Objects.equals(bodegaId, that.bodegaId) &&
               Objects.equals(precioUnitario, that.precioUnitario) &&
               Objects.equals(referencia, that.referencia) &&
               Objects.equals(notas, that.notas) &&
               Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, bodegaId, cantidad, precioUnitario, referencia, notas, fecha);
    }

    @Override
    public String toString() {
        return "CrearMovimientoSalidaRequest{"
               + "productoId=" + productoId +
               ", bodegaId=" + bodegaId +
               ", cantidad=" + cantidad +
               ", precioUnitario=" + precioUnitario +
               ", referencia='" + referencia + '\'' +
               ", notas='" + notas + '\'' +
               ", fecha=" + fecha +
               '}';
    }
}