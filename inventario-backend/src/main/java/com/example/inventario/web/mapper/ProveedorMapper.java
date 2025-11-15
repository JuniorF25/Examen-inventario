package com.example.inventario.web.mapper;

import com.example.inventario.domain.Proveedor;
import com.example.inventario.web.dto.ProveedorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {
    ProveedorDto toDto(Proveedor proveedor);
}
