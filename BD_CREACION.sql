-- Crear la tabla de Clientes
CREATE TABLE Clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    fecha_registro DATE DEFAULT CURRENT_DATE
);

-- Crear la tabla de Cuentas
CREATE TABLE Cuentas (
    cuenta_id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    tipo_cuenta VARCHAR(50) NOT NULL,
    saldo DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    fecha_apertura DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(cliente_id)
);

-- Crear la tabla de Transacciones
CREATE TABLE Transacciones (
    transaccion_id INT AUTO_INCREMENT PRIMARY KEY,
    cuenta_id INT,
    tipo_transaccion VARCHAR(50) NOT NULL,
    monto DECIMAL(15, 2) NOT NULL,
    fecha_transaccion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cuenta_id) REFERENCES Cuentas(cuenta_id)
);

-- Crear la tabla de Tarjetas
CREATE TABLE Tarjetas (
    tarjeta_id INT AUTO_INCREMENT PRIMARY KEY,
    cuenta_id INT,
    numero_tarjeta VARCHAR(16) UNIQUE NOT NULL,
    fecha_expiracion DATE NOT NULL,
    codigo_seguridad VARCHAR(3) NOT NULL,
    fecha_emision DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (cuenta_id) REFERENCES Cuentas(cuenta_id)
);
