package com.example.inventario.web.mapper;

import com.example.inventario.domain.Bodega;
import com.example.inventario.web.dto.BodegaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BodegaMapper {
    BodegaDto toDto(Bodega bodega);
}
