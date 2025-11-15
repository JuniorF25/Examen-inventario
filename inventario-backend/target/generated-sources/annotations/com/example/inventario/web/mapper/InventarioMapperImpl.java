package com.example.inventario.web.mapper;

import com.example.inventario.domain.Bodega;
import com.example.inventario.domain.Inventario;
import com.example.inventario.domain.Producto;
import com.example.inventario.web.dto.InventarioDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-15T09:45:45-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class InventarioMapperImpl implements InventarioMapper {

    @Override
    public InventarioDto toDto(Inventario inventario) {
        if ( inventario == null ) {
            return null;
        }

        InventarioDto inventarioDto = new InventarioDto();

        inventarioDto.setProductoId( inventarioProductoId( inventario ) );
        inventarioDto.setProductoSku( inventarioProductoSku( inventario ) );
        inventarioDto.setProductoNombre( inventarioProductoNombre( inventario ) );
        inventarioDto.setBodegaId( inventarioBodegaId( inventario ) );
        inventarioDto.setBodegaNombre( inventarioBodegaNombre( inventario ) );
        inventarioDto.setId( inventario.getId() );
        inventarioDto.setCantidad( inventario.getCantidad() );
        inventarioDto.setLastUpdated( inventario.getLastUpdated() );

        return inventarioDto;
    }

    private Long inventarioProductoId(Inventario inventario) {
        if ( inventario == null ) {
            return null;
        }
        Producto producto = inventario.getProducto();
        if ( producto == null ) {
            return null;
        }
        Long id = producto.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String inventarioProductoSku(Inventario inventario) {
        if ( inventario == null ) {
            return null;
        }
        Producto producto = inventario.getProducto();
        if ( producto == null ) {
            return null;
        }
        String sku = producto.getSku();
        if ( sku == null ) {
            return null;
        }
        return sku;
    }

    private String inventarioProductoNombre(Inventario inventario) {
        if ( inventario == null ) {
            return null;
        }
        Producto producto = inventario.getProducto();
        if ( producto == null ) {
            return null;
        }
        String nombre = producto.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private Long inventarioBodegaId(Inventario inventario) {
        if ( inventario == null ) {
            return null;
        }
        Bodega bodega = inventario.getBodega();
        if ( bodega == null ) {
            return null;
        }
        Long id = bodega.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String inventarioBodegaNombre(Inventario inventario) {
        if ( inventario == null ) {
            return null;
        }
        Bodega bodega = inventario.getBodega();
        if ( bodega == null ) {
            return null;
        }
        String nombre = bodega.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }
}
