package com.example.inventario.web.mapper;

import com.example.inventario.domain.Movimiento;
import com.example.inventario.web.dto.CrearMovimientoEntradaRequest;
import com.example.inventario.web.dto.CrearMovimientoSalidaRequest;
import com.example.inventario.web.dto.MovimientoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "producto.sku", target = "productoSku")
    @Mapping(source = "producto.nombre", target = "productoNombre")
    @Mapping(source = "bodega.id", target = "bodegaId")
    @Mapping(source = "bodega.nombre", target = "bodegaNombre")
    @Mapping(source = "proveedor.id", target = "proveedorId")
    @Mapping(source = "proveedor.nombre", target = "proveedorNombre")
    MovimientoDto toDto(Movimiento movimiento);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipo", expression = "java('E')")
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "bodega", ignore = true)
    @Mapping(target = "proveedor", ignore = true)
    @Mapping(target = "precioUnitario", ignore = true)
    Movimiento toEntity(CrearMovimientoEntradaRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipo", expression = "java('S')")
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "bodega", ignore = true)
    @Mapping(target = "proveedor", ignore = true)
    @Mapping(target = "costoUnitario", ignore = true)
    Movimiento toEntity(CrearMovimientoSalidaRequest request);
}
