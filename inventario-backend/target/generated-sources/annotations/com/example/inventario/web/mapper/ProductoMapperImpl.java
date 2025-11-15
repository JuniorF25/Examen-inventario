package com.example.inventario.web.mapper;

import com.example.inventario.domain.Producto;
import com.example.inventario.web.dto.CrearProductoRequest;
import com.example.inventario.web.dto.ProductoDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-15T09:45:45-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDto toDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDto productoDto = new ProductoDto();

        productoDto.setId( producto.getId() );
        productoDto.setSku( producto.getSku() );
        productoDto.setNombre( producto.getNombre() );
        productoDto.setDescripcion( producto.getDescripcion() );
        productoDto.setUnidadMedida( producto.getUnidadMedida() );
        productoDto.setPrecioCompra( producto.getPrecioCompra() );
        productoDto.setPrecioVenta( producto.getPrecioVenta() );
        productoDto.setActivo( producto.isActivo() );
        productoDto.setCreadoEn( producto.getCreadoEn() );

        return productoDto;
    }

    @Override
    public Producto toEntity(CrearProductoRequest request) {
        if ( request == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setSku( request.getSku() );
        producto.setNombre( request.getNombre() );
        producto.setDescripcion( request.getDescripcion() );
        producto.setUnidadMedida( request.getUnidadMedida() );
        producto.setPrecioCompra( request.getPrecioCompra() );
        producto.setPrecioVenta( request.getPrecioVenta() );

        return producto;
    }
}
