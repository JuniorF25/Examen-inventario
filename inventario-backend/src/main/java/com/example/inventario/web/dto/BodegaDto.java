package com.example.inventario.web.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class BodegaDto {
    private Long id;
    private String nombre;
    private String direccion;
    private boolean activa;
    private LocalDateTime creadoEn;

    // No-argument constructor
    public BodegaDto() {
    }

    // All-argument constructor
    public BodegaDto(Long id, String nombre, String direccion, boolean activa, LocalDateTime creadoEn) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.activa = activa;
        this.creadoEn = creadoEn;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isActiva() {
        return activa;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodegaDto bodegaDto = (BodegaDto) o;
        return activa == bodegaDto.activa &&
               Objects.equals(id, bodegaDto.id) &&
               Objects.equals(nombre, bodegaDto.nombre) &&
               Objects.equals(direccion, bodegaDto.direccion) &&
               Objects.equals(creadoEn, bodegaDto.creadoEn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, activa, creadoEn);
    }

    @Override
    public String toString() {
        return "BodegaDto{"
               + "id=" + id +
               ", nombre='" + nombre + "'"
               + ", direccion='" + direccion + "'"
               + ", activa=" + activa +
               ", creadoEn=" + creadoEn +
               '}';
    }
}