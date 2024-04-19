create database bd_inventario_dulceria;

use bd_inventario_dulceria;

-- Crea tabla usuarios --
create table tb_usuario(
idUsuario int (10) auto_increment primary key,
nombre varchar (30) not null,
apellido varchar (30) not null,
usuario varchar (15) not null,
password varchar (30) not null,
telefono varchar (10) not null
);

insert into tb_usuario(nombre, apellido, usuario, password, telefono)
values("David", "Sánchez", "bdavesm", "519941", "3045386489"); 

select * from tb_usuario;

select concat(nombre, " ", apellido) as Nombres, usuario, password from tb_usuario
where usuario = "gatete" and password = "519941";

update tb_usuario
SET  nombre = "Kikoso", usuario = "gatete"
where idUsuario = 2;

-- Crea tabla clientes --
create table tb_cliente(
idCliente int (10) auto_increment primary key,
nombre varchar (30) not null,
apellido varchar (30) not null,
cedula varchar (15) not null,
email varchar (30) not null,
telefono varchar (10) not null,
direccion varchar (30) 
);

-- Crea tabla categoria --
create table tb_categoria(
idCategoria int (10) auto_increment primary key,
descripcion varchar (50) not null,
estado int (1) not null
);

-- Crea tabla producto --
create table tb_producto(
idProducto int (10) auto_increment primary key,
nombre varchar (50) not null,
cantidad int (11) not null,
precio double(10,2) not null,
descripcion varchar (50) not null,
porcentajeIva int (2) not null,
idCategoria int (10) not null,
estado int (1) not null
);

-- Crea tabla cabecera venta --
create table tb_cabecera_venta(
idCabeceraVenta int (10) auto_increment primary key,
idCliente int (10) not null,
valorPagar double (10,2) not null,
fechaVenta date not null,
estado int (1) not null
);

-- Crea tabla detalle venta --
create table tb_detalle_venta(
idDetalleVenta int (10) auto_increment primary key,
idCabeceraVenta int (10) not null,
idProducto int (10) not null,
cantidad int (10) not null,
precioUnitario double (10,2) not null,
subtotal double (10,2) not null,
descuento double (10,2) not null,
iva double (10,2) not null,
totalPagar double (10,2) not null,
estado int (1) not null
);

show tables;
