package com.example.inventario.web.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProveedorDto {
    private Long id;
    private String nombre;
    private String contacto;
    private String telefono;
    private String email;
    private String direccion;
    private boolean activo;
    private LocalDateTime creadoEn;

    // No-argument constructor
    public ProveedorDto() {
    }

    // All-argument constructor
    public ProveedorDto(Long id, String nombre, String contacto, String telefono, String email, String direccion, boolean activo, LocalDateTime creadoEn) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.activo = activo;
        this.creadoEn = creadoEn;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        ProveedorDto that = (ProveedorDto) o;
        return activo == that.activo &&
               Objects.equals(id, that.id) &&
               Objects.equals(nombre, that.nombre) &&
               Objects.equals(contacto, that.contacto) &&
               Objects.equals(telefono, that.telefono) &&
               Objects.equals(email, that.email) &&
               Objects.equals(direccion, that.direccion) &&
               Objects.equals(creadoEn, that.creadoEn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, contacto, telefono, email, direccion, activo, creadoEn);
    }

    @Override
    public String toString() {
        return String.format("ProveedorDto{id=%d, nombre='%s', contacto='%s', telefono='%s', email='%s', direccion='%s', activo=%b, creadoEn=%s}",
                             id, nombre, contacto, telefono, email, direccion, activo, creadoEn);
    }
}