package com.example.inventario.web.mapper;

import com.example.inventario.domain.Producto;
import com.example.inventario.web.dto.CrearProductoRequest;
import com.example.inventario.web.dto.ProductoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDto toDto(Producto producto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "creadoEn", ignore = true)
    Producto toEntity(CrearProductoRequest request);
}
