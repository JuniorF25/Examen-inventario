-- V1__schema.sql

CREATE TABLE proveedores (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100),
    telefono VARCHAR(20),
    email VARCHAR(100),
    direccion VARCHAR(255),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE bodegas (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_bodega_nombre UNIQUE (nombre)
);

CREATE TABLE productos (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(50) NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    unidad_medida VARCHAR(20) NOT NULL,
    precio_compra NUMERIC(10, 2),
    precio_venta NUMERIC(10, 2),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    creado_en TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_producto_sku UNIQUE (sku)
);

CREATE TABLE productos_proveedores (
    producto_id BIGINT NOT NULL,
    proveedor_id BIGINT NOT NULL,
    codigo_proveedor VARCHAR(50),
    es_preferido BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (producto_id, proveedor_id),
    CONSTRAINT fk_prodprov_producto FOREIGN KEY (producto_id) REFERENCES productos(id),
    CONSTRAINT fk_prodprov_proveedor FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
);

CREATE TABLE inventario (
    id BIGSERIAL PRIMARY KEY,
    producto_id BIGINT NOT NULL,
    bodega_id BIGINT NOT NULL,
    cantidad INTEGER NOT NULL,
    last_updated TIMESTAMP,
    CONSTRAINT uk_inventario_producto_bodega UNIQUE (producto_id, bodega_id),
    CONSTRAINT fk_inventario_producto FOREIGN KEY (producto_id) REFERENCES productos(id),
    CONSTRAINT fk_inventario_bodega FOREIGN KEY (bodega_id) REFERENCES bodegas(id)
);

CREATE TABLE movimientos (
    id BIGSERIAL PRIMARY KEY,
    fecha TIMESTAMP NOT NULL,
    tipo CHAR(1) NOT NULL,
    producto_id BIGINT NOT NULL,
    bodega_id BIGINT NOT NULL,
    proveedor_id BIGINT,
    cantidad INTEGER NOT NULL,
    costo_unitario NUMERIC(10, 2),
    precio_unitario NUMERIC(10, 2),
    referencia VARCHAR(100),
    notas TEXT,
    CONSTRAINT fk_movimiento_producto FOREIGN KEY (producto_id) REFERENCES productos(id),
    CONSTRAINT fk_movimiento_bodega FOREIGN KEY (bodega_id) REFERENCES bodegas(id),
    CONSTRAINT fk_movimiento_proveedor FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
);
