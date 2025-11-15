package com.example.inventario.repository;

import com.example.inventario.domain.ProductoProveedor;
import com.example.inventario.domain.ProductoProveedorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, ProductoProveedorId> {
}
