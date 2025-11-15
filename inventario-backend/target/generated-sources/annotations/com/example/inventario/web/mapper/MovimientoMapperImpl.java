package com.example.inventario.web.mapper;

import com.example.inventario.domain.Bodega;
import com.example.inventario.domain.Movimiento;
import com.example.inventario.domain.Producto;
import com.example.inventario.domain.Proveedor;
import com.example.inventario.web.dto.CrearMovimientoEntradaRequest;
import com.example.inventario.web.dto.CrearMovimientoSalidaRequest;
import com.example.inventario.web.dto.MovimientoDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-15T09:45:45-0600",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class MovimientoMapperImpl implements MovimientoMapper {

    @Override
    public MovimientoDto toDto(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }

        MovimientoDto movimientoDto = new MovimientoDto();

        movimientoDto.setProductoId( movimientoProductoId( movimiento ) );
        movimientoDto.setProductoSku( movimientoProductoSku( movimiento ) );
        movimientoDto.setProductoNombre( movimientoProductoNombre( movimiento ) );
        movimientoDto.setBodegaId( movimientoBodegaId( movimiento ) );
        movimientoDto.setBodegaNombre( movimientoBodegaNombre( movimiento ) );
        movimientoDto.setProveedorId( movimientoProveedorId( movimiento ) );
        movimientoDto.setProveedorNombre( movimientoProveedorNombre( movimiento ) );
        movimientoDto.setId( movimiento.getId() );
        movimientoDto.setFecha( movimiento.getFecha() );
        movimientoDto.setTipo( movimiento.getTipo() );
        movimientoDto.setCantidad( movimiento.getCantidad() );
        movimientoDto.setCostoUnitario( movimiento.getCostoUnitario() );
        movimientoDto.setPrecioUnitario( movimiento.getPrecioUnitario() );
        movimientoDto.setReferencia( movimiento.getReferencia() );
        movimientoDto.setNotas( movimiento.getNotas() );

        return movimientoDto;
    }

    @Override
    public Movimiento toEntity(CrearMovimientoEntradaRequest request) {
        if ( request == null ) {
            return null;
        }

        Movimiento movimiento = new Movimiento();

        movimiento.setFecha( request.getFecha() );
        movimiento.setCantidad( request.getCantidad() );
        movimiento.setCostoUnitario( request.getCostoUnitario() );
        movimiento.setReferencia( request.getReferencia() );
        movimiento.setNotas( request.getNotas() );

        movimiento.setTipo( 'E' );

        return movimiento;
    }

    @Override
    public Movimiento toEntity(CrearMovimientoSalidaRequest request) {
        if ( request == null ) {
            return null;
        }

        Movimiento movimiento = new Movimiento();

        movimiento.setFecha( request.getFecha() );
        movimiento.setCantidad( request.getCantidad() );
        movimiento.setPrecioUnitario( request.getPrecioUnitario() );
        movimiento.setReferencia( request.getReferencia() );
        movimiento.setNotas( request.getNotas() );

        movimiento.setTipo( 'S' );

        return movimiento;
    }

    private Long movimientoProductoId(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }
        Producto producto = movimiento.getProducto();
        if ( producto == null ) {
            return null;
        }
        Long id = producto.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String movimientoProductoSku(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }
        Producto producto = movimiento.getProducto();
        if ( producto == null ) {
            return null;
        }
        String sku = producto.getSku();
        if ( sku == null ) {
            return null;
        }
        return sku;
    }

    private String movimientoProductoNombre(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }
        Producto producto = movimiento.getProducto();
        if ( producto == null ) {
            return null;
        }
        String nombre = producto.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private Long movimientoBodegaId(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }
        Bodega bodega = movimiento.getBodega();
        if ( bodega == null ) {
            return null;
        }
        Long id = bodega.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String movimientoBodegaNombre(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }
        Bodega bodega = movimiento.getBodega();
        if ( bodega == null ) {
            return null;
        }
        String nombre = bodega.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private Long movimientoProveedorId(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }
        Proveedor proveedor = movimiento.getProveedor();
        if ( proveedor == null ) {
            return null;
        }
        Long id = proveedor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String movimientoProveedorNombre(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }
        Proveedor proveedor = movimiento.getProveedor();
        if ( proveedor == null ) {
            return null;
        }
        String nombre = proveedor.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }
}
