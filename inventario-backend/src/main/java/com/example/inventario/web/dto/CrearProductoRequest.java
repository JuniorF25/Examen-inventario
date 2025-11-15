package com.example.inventario.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class CrearProductoRequest {

    @NotBlank(message = "El SKU no puede estar vacío")
    @Size(max = 50, message = "El SKU no puede tener más de 50 caracteres")
    private String sku;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 150, message = "El nombre no puede tener más de 150 caracteres")
    private String nombre;

    private String descripcion;

    @NotBlank(message = "La unidad de medida no puede estar vacía")
    @Size(max = 20, message = "La unidad de medida no puede tener más de 20 caracteres")
    private String unidadMedida;

    @PositiveOrZero(message = "El precio de compra debe ser un valor positivo o cero")
    private BigDecimal precioCompra;

    @PositiveOrZero(message = "El precio de venta debe ser un valor positivo o cero")
    private BigDecimal precioVenta;

    // Getters
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

    // Setters
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
}
