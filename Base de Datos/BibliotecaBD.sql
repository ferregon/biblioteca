CREATE DATABASE BIBLIOTECA;
USE BIBLIOTECA;

CREATE TABLE ALUMNO(
DNI_Alumno varchar(8) primary key not null,
Nombre varchar(25)not null,
Apellido_Paterno varchar(30)not null,
Apellido_Materno varchar(30)not null,
Sexo varchar(10)not null,
Grado varchar(20)not null,
Seccion varchar(2)not null,
Direccion varchar(35)not null,
Telefono varchar(9)not null

)engine=innodb;

CREATE TABLE PROFESOR(
DNI_Profesor varchar(8) primary key not null,
Nombre varchar(25)not null,
Apellido_Paterno varchar(30)not null,
Apellido_Materno varchar(30)not null,
Sexo varchar(10)not null,
Especialidad varchar(30)not null,
Telefono varchar(9)not null,
Direccion varchar(45)not null

)engine=InnoDB;

CREATE TABLE CATEGORIA(
id_categoria varchar(5) primary key not null,
categoria varchar(35) not null
)engine=InnoDB;

CREATE TABLE LIBROS(
Cod_Libro varchar(8) primary key not null,
Nombre_Libro varchar(50)not null,
id_categoria varchar(5) not null,
index fk_lib_categ(id_categoria asc),
constraint fk_lib_categ foreign key(id_categoria) references CATEGORIA(id_categoria),
Autor varchar(30)not null,
Editorial varchar(30)not null,
Año varchar(4)not null
)engine=InnoDB;

CREATE TABLE PRESTAMO_ALUMNO(
Recibo_alumno int unsigned auto_increment key not null,
DNI_Alumno varchar(8) NOT NULL,
Cod_Libro varchar(8)NOT NULL,
Cantidad int not null,
Fecha_Prestamo date not null,
Fecha_Devolucion date not null,
index fk_alumno_prest(DNI_Alumno asc),
CONSTRAINT fk_alumno_prest foreign key(DNI_Alumno)references ALUMNO(DNI_Alumno),
index fk_libro_prest(Cod_Libro asc),
CONSTRAINT fk_libro_prest foreign key(Cod_Libro)references LIBROS(Cod_Libro)
)engine=InnoDB;

CREATE TABLE PRESTAMO_PROFESOR(
Recibo_profe int unsigned auto_increment key not null,
DNI_Profesor varchar(8) NOT NULL,
Cod_Libro varchar(8)NOT NULL,
Cantidad int not null,
Fecha_Prestamo date not null,
Fecha_Devolucion date not null,
index fk_profesor_prest(DNI_Profesor asc),
CONSTRAINT fk_profesor_prest foreign key(DNI_Profesor)references PROFESOR(DNI_Profesor),
index fk_lib_prest(Cod_Libro asc),
CONSTRAINT fk_lib_prest foreign key(Cod_Libro)references LIBROS(Cod_Libro)
)engine=InnoDB;


create table Usuario
    (
      id varchar(5) primary key not null,
      usuario varchar(30) not null,
      password varchar(30)not null,
      Tipo_usuario varchar(30) not null
      )engine=InnoDB;


