package com.example.inventario.repository;

import com.example.inventario.domain.Inventario;
import jakarta.persistence.LockModeType;
import com.example.inventario.web.dto.InventarioTotalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long>, JpaSpecificationExecutor<Inventario> {

    Optional<Inventario> findByProductoIdAndBodegaId(Long productoId, Long bodegaId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT i FROM Inventario i WHERE i.producto.id = :productoId AND i.bodega.id = :bodegaId")
    Optional<Inventario> findByProductoIdAndBodegaIdForUpdate(Long productoId, Long bodegaId);

    @Query("SELECT new com.example.inventario.web.dto.InventarioTotalDto(i.producto.id, i.producto.sku, i.producto.nombre, SUM(i.cantidad)) " +
           "FROM Inventario i GROUP BY i.producto.id, i.producto.sku, i.producto.nombre")
    Page<InventarioTotalDto> findTotalesPorProducto(Pageable pageable);
}
