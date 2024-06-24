-- Inserción de datos de ejemplo en la tabla Clientes
INSERT INTO Clientes (cliente_id, nombre, direccion, telefono, email, fecha_registro) VALUES
(1, 'Juan Pérez', 'Calle Falsa 123', '123-456-7890', 'juan.perez@example.com', CURRENT_DATE),
(2, 'María Gómez', 'Avenida Siempre Viva 456', '456-789-0123', 'maria.gomez@example.com', CURRENT_DATE),
(3, 'Carlos Rodríguez', 'Calle de la Amargura 789', '789-012-3456', 'carlos.rodriguez@example.com', CURRENT_DATE),
(4, 'Ana Martínez', 'Boulevard de los Sueños Rotos 321', '321-654-9870', 'ana.martinez@example.com', CURRENT_DATE),
(5, 'Pedro López', 'Plaza de la Concordia 654', '654-987-0123', 'pedro.lopez@example.com', CURRENT_DATE);

-- Inserción de datos de ejemplo en la tabla Cuentas
INSERT INTO Cuentas (cuenta_id, cliente_id, tipo_cuenta, saldo, fecha_apertura) VALUES
(1, 1, 'Corriente', 1500.00, CURRENT_DATE),
(2, 2, 'Ahorro', 3000.00, CURRENT_DATE),
(3, 3, 'Débito', 500.00, CURRENT_DATE),
(4, 4, 'Corriente', 2000.00, CURRENT_DATE),
(5, 5, 'Ahorro', 1000.00, CURRENT_DATE);

-- Inserción de datos de ejemplo en la tabla Transacciones
INSERT INTO Transacciones (transaccion_id, cuenta_id, tipo_transaccion, monto, fecha_transaccion) VALUES
(1, 1, 'Depósito', 500.00, CURRENT_TIMESTAMP),
(2, 1, 'Retiro', -200.00, CURRENT_TIMESTAMP),
(3, 1, 'Transferencia', -100.00, CURRENT_TIMESTAMP),
(4, 2, 'Compra', -50.00, CURRENT_TIMESTAMP),
(5, 3, 'Depósito', 1000.00, CURRENT_TIMESTAMP);

-- Inserción de datos de ejemplo en la tabla Tarjetas
INSERT INTO Tarjetas (tarjeta_id, cuenta_id, numero_tarjeta, fecha_expiracion, codigo_seguridad, fecha_emision) VALUES
(1, 5, '1111222233334444', '2025-12-31', '123', CURRENT_DATE),
(2, 3, '5555666677778888', '2024-06-30', '456', CURRENT_DATE);
