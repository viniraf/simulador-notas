create database if not exists simulador_notas;
use simulador_notas;

create table usuarios (
	id int primary key not null auto_increment,
    usuario varchar(50) not null,
    senha varchar(50) not null
);

insert into usuarios(usuario, senha) values
('admin', 123);

create table materias (
	id int primary key auto_increment,
    nome varchar(50) not null
);

