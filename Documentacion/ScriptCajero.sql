CREATE DATABASE IF NOT EXISTS cajero;
USE cajero;

DROP TABLE IF EXISTS pertenece;
DROP TABLE IF EXISTS movimientos;
DROP TABLE IF EXISTS clientes;
DROP TABLE IF EXISTS tarjetas;
DROP TABLE IF EXISTS cuentas;
DROP TABLE IF EXISTS administrador;

CREATE TABLE  administrador (
  usuario VARCHAR(20) PRIMARY KEY,
  contraseña VARCHAR(15) NOT NULL 
);

CREATE TABLE  clientes (
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(20) NOT NULL,
  apell1 VARCHAR(20) NOT NULL,
  apell2 VARCHAR(20),
  direccion VARCHAR(20) NOT NULL,
  correo VARCHAR(40),
  telefono VARCHAR(9) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  usuad VARCHAR(20),
  FOREIGN KEY (usuad) REFERENCES administrador(usuario)
);

CREATE TABLE  cuentas (
  numCuenta VARCHAR(24) PRIMARY KEY, 
  saldo DOUBLE NOT NULL,
  usuad VARCHAR(20),
  FOREIGN KEY (usuad) REFERENCES administrador(usuario)
);

CREATE TABLE  tarjetas (
  numero BIGINT UNSIGNED PRIMARY KEY,
  pin INT UNSIGNED NOT NULL,
  CVV INT UNSIGNED NOT NULL,
  validez DATE NOT NULL,
  estado ENUM('noBloqueado' , 'bloqueado') NOT NULL,
  numCuenta VARCHAR(24) NOT NULL,
  usuad VARCHAR(20),
  FOREIGN KEY (usuad) REFERENCES administrador(usuario),
  FOREIGN KEY (numCuenta) REFERENCES cuentas(numCuenta) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE  movimientos (
  codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  fecha DATE NOT NULL,
  tipo ENUM('ingreso' , 'retirada', 'transferencia'),
  autor VARCHAR(9) NOT NULL,
  numCuenta VARCHAR(24),
  FOREIGN KEY (autor) REFERENCES clientes(dni) ON DELETE CASCADE ON UPDATE CASCADE , 
  FOREIGN KEY (numCuenta) REFERENCES cuentas(numCuenta) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE pertenece (
	dni VARCHAR(9),
	numCuenta VARCHAR(24),
    FOREIGN KEY (numCuenta) REFERENCES cuentas(numCuenta) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (dni) REFERENCES clientes(dni) ON DELETE CASCADE ON UPDATE CASCADE

);


-- Inserción de datos en la tabla administrador
INSERT INTO administrador (usuario, contraseña) 
VALUES ('admin', 'admin');

-- Inserción de datos en la tabla clientes
INSERT INTO clientes (dni, nombre, apell1, apell2, direccion, correo, telefono, fechaNacimiento, usuad) 
VALUES 
('11111111A', 'Juan', 'Pérez', 'Gómez', 'Calle Mayor 1', 'juanperez@mail.com', 123456789, '1985-07-12', 'admin'),
('22222222B', 'Ana', 'Martínez', 'García', 'Avenida Libertad 4', 'anamartinez@mail.com', 987654321, '1990-02-25', 'admin'),
('33333333C', 'Carlos', 'Gutiérrez', 'Fernández', 'Plaza España 7', 'carlosgutierrez@mail.com', 654123789, '1978-11-18', 'admin'),
('44444444D', 'María', 'Sánchez', 'González', 'Calle Real 10', 'mariasanchez@mail.com', 741852963, '1989-06-30', 'admin'),
('55555555E', 'Miguel', 'Hernández', 'Ruíz', 'Paseo Marítimo 15', 'miguelhernandez@mail.com', 369258147, '1982-09-08', 'admin'),
('66666666F', 'Sofía', 'López', 'Rodríguez', 'Calle San Juan 22', 'sofialopez@mail.com', 852963741, '1995-03-01', 'admin'),
('77777777G', 'David', 'Ramírez', 'Moreno', 'Calle Mayor 3', 'davidramirez@mail.com', 456123789, '1987-12-24', 'admin'),
('88888888H', 'Lucía', 'Torres', 'Ruiz', 'Avenida de la Paz 5', 'luciatorres@mail.com', 123789456, '1992-08-14', 'admin'),
('99999999I', 'Pablo', 'Castro', 'Santos', 'Calle del Sol 8', 'pablocastro@mail.com', 789456123, '1980-05-16', 'admin'),
('00000000J', 'Elena', 'López', 'Pérez', 'Plaza Mayor 2', 'elenalopez@mail.com', 321654987, '1998-01-20', 'admin');

-- Inserción de datos en la tabla cuentas
INSERT INTO cuentas (numCuenta, saldo, usuad) VALUES 
('ES1012345678901234567890', 500.00, 'admin'),
('ES2023456789012345678901', 1250.00, 'admin'),
('ES3034567890123456789012', 230.50, 'admin'),
('ES4045678901234567890123', 15000.00, 'admin'),
('ES5056789012345678901234', 850.20, 'admin'),
('ES6067890123456789012345', 5000.00, 'admin'),
('ES7078901234567890123456', 270.75, 'admin'),
('ES8089012345678901234567', 100000.00, 'admin'),
('ES9090123456789012345678', 305.90, 'admin'),
('ES0101234567890123456789', 800.00, 'admin');

-- Inserción de datos en la tabla tarjetas

INSERT INTO tarjetas (numero, pin, CVV, validez, estado, numCuenta, usuad) VALUES 
(1111222233334444, 1234, 567, '2024-05-01', 'noBloqueado', 'ES2023456789012345678901', 'admin'),
(2222333344445555, 4321, 678, '2023-12-01', 'noBloqueado', 'ES3034567890123456789012', 'admin'),
(3333444455556666, 9876, 321, '2025-06-01', 'noBloqueado', 'ES4045678901234567890123', 'admin'),
(4444555566667777, 5678, 432, '2026-03-01', 'noBloqueado', 'ES5056789012345678901234', 'admin'),
(5555666677778888, 1111, 234, '2024-02-01', 'noBloqueado', 'ES6067890123456789012345', 'admin'),
(6666777788889999, 2222, 345, '2026-01-01', 'noBloqueado', 'ES7078901234567890123456', 'admin'),
(7777888899990000, 5555, 789, '2023-08-01', 'noBloqueado', 'ES8089012345678901234567', 'admin'),
(8888999900001111, 3333, 456, '2025-09-01', 'noBloqueado', 'ES9090123456789012345678', 'admin'),
(9999000011112222, 9999, 876, '2022-11-01', 'noBloqueado', 'ES0101234567890123456789', 'admin'),
(0000111122223333, 1111, 321, '2024-07-01', 'noBloqueado', 'ES1012345678901234567890', 'admin');

-- Inserción de datos en la tabla movimientos

INSERT INTO movimientos (fecha, tipo, autor, numCuenta) VALUES 
('2022-01-01', 'ingreso', '11111111A', 'ES2023456789012345678901'),
('2022-01-02', 'ingreso', '22222222B', 'ES3034567890123456789012'),
('2022-01-03', 'ingreso', '33333333C', 'ES4045678901234567890123'),
('2022-01-04', 'retirada', '44444444D', 'ES5056789012345678901234'),
('2022-01-05', 'retirada', '55555555E', 'ES6067890123456789012345'),
('2022-01-06', 'retirada', '66666666F', 'ES7078901234567890123456'),
('2022-01-07', 'transferencia', '77777777G', 'ES8089012345678901234567'),
('2022-01-08', 'transferencia', '88888888H', 'ES9090123456789012345678'),
('2022-01-09', 'transferencia', '99999999I', 'ES0101234567890123456789'),
('2022-01-10', 'ingreso', '00000000J', 'ES1012345678901234567890');

-- Inserción de datos datos en la tabla pertenece

INSERT INTO pertenece (dni, numCuenta) VALUES 
('11111111A','ES2023456789012345678901'),
('22222222B','ES3034567890123456789012'),
('33333333C','ES4045678901234567890123'),
('44444444D','ES5056789012345678901234'),
('55555555E','ES6067890123456789012345'),
('66666666F','ES7078901234567890123456'),
('77777777G','ES8089012345678901234567'),
('88888888H','ES9090123456789012345678'),
('99999999I','ES0101234567890123456789'),
('00000000J','ES1012345678901234567890');
