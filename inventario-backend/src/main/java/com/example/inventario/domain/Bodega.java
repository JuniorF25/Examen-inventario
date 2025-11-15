package com.example.inventario.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bodegas", uniqueConstraints = {
    @UniqueConstraint(name = "uk_bodega_nombre", columnNames = "nombre")
})
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String direccion;

    @Column(nullable = false)
    private boolean activa = true; // Default value

    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    // No-argument constructor
    public Bodega() {
    }

    // All-argument constructor (excluding id and creadoEn for builder-like usage)
    public Bodega(String nombre, String direccion, boolean activa) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.activa = activa;
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
        Bodega bodega = (Bodega) o;
        return id != null && Objects.equals(id, bodega.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return String.format("Bodega{id=%d, nombre='%s', direccion='%s', activa=%b, creadoEn=%s}",
                             id, nombre, direccion, activa, creadoEn);
    }
}