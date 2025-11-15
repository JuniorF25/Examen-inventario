package com.example.inventario.web.mapper;

import com.example.inventario.domain.Inventario;
import com.example.inventario.web.dto.InventarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "producto.sku", target = "productoSku")
    @Mapping(source = "producto.nombre", target = "productoNombre")
    @Mapping(source = "bodega.id", target = "bodegaId")
    @Mapping(source = "bodega.nombre", target = "bodegaNombre")
    InventarioDto toDto(Inventario inventario);
}
