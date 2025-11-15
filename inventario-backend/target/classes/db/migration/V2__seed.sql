-- V2__seed.sql

-- Proveedores
INSERT INTO proveedores (nombre, contacto, telefono, email, direccion)
SELECT nombre, contacto, telefono, email, direccion
FROM (VALUES
('Proveedor A', 'Juan Perez', '123456789', 'juan.perez@proveedora.com', 'Calle Falsa 123'),
('Proveedor B', 'Ana Gomez', '987654321', 'ana.gomez@proveedorb.com', 'Avenida Siempreviva 742'),
('Proveedor C', 'Carlos Lopez', '555555555', 'carlos.lopez@proveedorc.com', 'Plaza Mayor 1')
) AS v(nombre, contacto, telefono, email, direccion)
WHERE NOT EXISTS (SELECT 1 FROM proveedores p WHERE p.nombre = v.nombre);

-- Bodegas
INSERT INTO bodegas (nombre, direccion)
SELECT nombre, direccion
FROM (VALUES
('Bodega Principal', 'Almacén Central, Zona Industrial'),
('Bodega Secundaria', 'Sucursal Norte, Calle 45')
) AS v(nombre, direccion)
WHERE NOT EXISTS (SELECT 1 FROM bodegas b WHERE b.nombre = v.nombre);

-- Productos
INSERT INTO productos (sku, nombre, descripcion, unidad_medida, precio_compra, precio_venta)
SELECT sku, nombre, descripcion, unidad_medida, precio_compra, precio_venta
FROM (VALUES
('LAP-MAC-M3', 'Laptop MacBook Pro M3', 'Laptop de alto rendimiento', 'unidad', 1500.00, 2500.00),
('MON-DELL-27', 'Monitor Dell 27"', 'Monitor 4K UHD', 'unidad', 300.00, 450.00),
('TEC-LOG-MX', 'Teclado Logitech MX Keys', 'Teclado inalámbrico retroiluminado', 'unidad', 90.00, 120.00),
('MSE-LOG-MXM3', 'Mouse Logitech MX Master 3', 'Mouse ergonómico avanzado', 'unidad', 80.00, 110.00),
('CAB-USB-C-1M', 'Cable USB-C 1m', 'Cable de datos y carga 1 metro', 'unidad', 2.50, 5.00)
) AS v(sku, nombre, descripcion, unidad_medida, precio_compra, precio_venta)
WHERE NOT EXISTS (SELECT 1 FROM productos p WHERE p.sku = v.sku);

-- Movimientos de Entrada (simulando compras iniciales)
-- Esto también creará el inventario inicial
-- Movimiento 1: 10 Laptops del Proveedor A en Bodega Principal
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, proveedor_id, cantidad, costo_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'E', 1, 1, 1, 10, 1500.00, 'FAC-COMP-001');
INSERT INTO inventario (producto_id, bodega_id, cantidad, last_updated) VALUES (1, 1, 10, CURRENT_TIMESTAMP)
ON CONFLICT (producto_id, bodega_id) DO UPDATE SET cantidad = inventario.cantidad + 10, last_updated = CURRENT_TIMESTAMP;

-- Movimiento 2: 20 Monitores del Proveedor B en Bodega Principal
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, proveedor_id, cantidad, costo_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'E', 2, 1, 2, 20, 300.00, 'FAC-COMP-002');
INSERT INTO inventario (producto_id, bodega_id, cantidad, last_updated) VALUES (2, 1, 20, CURRENT_TIMESTAMP)
ON CONFLICT (producto_id, bodega_id) DO UPDATE SET cantidad = inventario.cantidad + 20, last_updated = CURRENT_TIMESTAMP;

-- Movimiento 3: 50 Teclados del Proveedor C en Bodega Secundaria
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, proveedor_id, cantidad, costo_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'E', 3, 2, 3, 50, 90.00, 'FAC-COMP-003');
INSERT INTO inventario (producto_id, bodega_id, cantidad, last_updated) VALUES (3, 2, 50, CURRENT_TIMESTAMP)
ON CONFLICT (producto_id, bodega_id) DO UPDATE SET cantidad = inventario.cantidad + 50, last_updated = CURRENT_TIMESTAMP;

-- Movimiento 4: 50 Mouses del Proveedor C en Bodega Secundaria
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, proveedor_id, cantidad, costo_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'E', 4, 2, 3, 50, 80.00, 'FAC-COMP-004');
INSERT INTO inventario (producto_id, bodega_id, cantidad, last_updated) VALUES (4, 2, 50, CURRENT_TIMESTAMP)
ON CONFLICT (producto_id, bodega_id) DO UPDATE SET cantidad = inventario.cantidad + 50, last_updated = CURRENT_TIMESTAMP;

-- Movimiento 5: 100 Cables del Proveedor A en Bodega Principal
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, proveedor_id, cantidad, costo_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'E', 5, 1, 1, 100, 2.50, 'FAC-COMP-005');
INSERT INTO inventario (producto_id, bodega_id, cantidad, last_updated) VALUES (5, 1, 100, CURRENT_TIMESTAMP)
ON CONFLICT (producto_id, bodega_id) DO UPDATE SET cantidad = inventario.cantidad + 100, last_updated = CURRENT_TIMESTAMP;


-- Movimientos de Salida (simulando ventas)
-- Movimiento 6: Venta de 2 Laptops de Bodega Principal
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, cantidad, precio_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'S', 1, 1, 2, 2500.00, 'VEN-ONLINE-001');
UPDATE inventario SET cantidad = cantidad - 2, last_updated = CURRENT_TIMESTAMP WHERE producto_id = 1 AND bodega_id = 1;

-- Movimiento 7: Venta de 5 Monitores de Bodega Principal
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, cantidad, precio_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'S', 2, 1, 5, 450.00, 'VEN-ONLINE-002');
UPDATE inventario SET cantidad = cantidad - 5, last_updated = CURRENT_TIMESTAMP WHERE producto_id = 2 AND bodega_id = 1;

-- Movimiento 8: Venta de 10 Teclados de Bodega Secundaria
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, cantidad, precio_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'S', 3, 2, 10, 120.00, 'VEN-TIENDA-001');
UPDATE inventario SET cantidad = cantidad - 10, last_updated = CURRENT_TIMESTAMP WHERE producto_id = 3 AND bodega_id = 2;

-- Movimiento 9: Venta de 10 Mouses de Bodega Secundaria
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, cantidad, precio_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'S', 4, 2, 10, 110.00, 'VEN-TIENDA-002');
UPDATE inventario SET cantidad = cantidad - 10, last_updated = CURRENT_TIMESTAMP WHERE producto_id = 4 AND bodega_id = 2;

-- Movimiento 10: Venta de 20 Cables de Bodega Principal
INSERT INTO movimientos (fecha, tipo, producto_id, bodega_id, cantidad, precio_unitario, referencia) VALUES
(CURRENT_TIMESTAMP, 'S', 5, 1, 20, 5.00, 'VEN-ONLINE-003');
UPDATE inventario SET cantidad = cantidad - 20, last_updated = CURRENT_TIMESTAMP WHERE producto_id = 5 AND bodega_id = 1;
