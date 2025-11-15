package com.example.inventario.web.mapper;

import com.example.inventario.domain.Bodega;
import com.example.inventario.web.dto.BodegaDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-15T09:45:45-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class BodegaMapperImpl implements BodegaMapper {

    @Override
    public BodegaDto toDto(Bodega bodega) {
        if ( bodega == null ) {
            return null;
        }

        BodegaDto bodegaDto = new BodegaDto();

        bodegaDto.setId( bodega.getId() );
        bodegaDto.setNombre( bodega.getNombre() );
        bodegaDto.setDireccion( bodega.getDireccion() );
        bodegaDto.setActiva( bodega.isActiva() );
        bodegaDto.setCreadoEn( bodega.getCreadoEn() );

        return bodegaDto;
    }
}
