CREATE TABLE Usuarios (
    id serial,
    tipo_identificacion VARCHAR(50),
    numero_identificacion VARCHAR(50) PRIMARY KEY,
    nombres VARCHAR(100),
    apellido VARCHAR(100),
    correo_electronico VARCHAR(100),
    fecha_nacimiento DATE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Cuentas (
    id SERIAL PRIMARY KEY,
    tipo_cuenta VARCHAR(50),
    numero_cuenta VARCHAR(50),
    estado VARCHAR(20),
    saldo NUMERIC(15, 2),
    exenta_gmf BOOLEAN,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id VARCHAR(50)


CREATE TABLE Movimientos (
    id SERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(20) NOT NULL,
    tipo_movimiento VARCHAR(50) NOT NULL,
    saldo DECIMAL(15, 2) NOT NULL,
    saldo_actual DECIMAL(15, 2) NOT NULL,
    fecha_movimiento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id VARCHAR(50)
);
