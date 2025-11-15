package com.example.inventario.web.mapper;

import com.example.inventario.domain.Proveedor;
import com.example.inventario.web.dto.ProveedorDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-15T09:45:45-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class ProveedorMapperImpl implements ProveedorMapper {

    @Override
    public ProveedorDto toDto(Proveedor proveedor) {
        if ( proveedor == null ) {
            return null;
        }

        ProveedorDto proveedorDto = new ProveedorDto();

        proveedorDto.setId( proveedor.getId() );
        proveedorDto.setNombre( proveedor.getNombre() );
        proveedorDto.setContacto( proveedor.getContacto() );
        proveedorDto.setTelefono( proveedor.getTelefono() );
        proveedorDto.setEmail( proveedor.getEmail() );
        proveedorDto.setDireccion( proveedor.getDireccion() );
        proveedorDto.setActivo( proveedor.isActivo() );
        proveedorDto.setCreadoEn( proveedor.getCreadoEn() );

        return proveedorDto;
    }
}
