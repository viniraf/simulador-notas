drop database if exists SimuladorNotas;
create database SimuladorNotas;
use SimuladorNotas;

create table student (
id				int				auto_increment			primary key,
name			varchar(50)		not null,
cpf				varchar(20)		not null				unique,
email			varchar(50)		not null				unique,
registration	int				not null				unique,
login			varchar(30)		not null				unique,
password		varchar(40)		not null
);

create table matter (
id				int				auto_increment		primary key,
name			varchar(50)		not null			unique
);

create table grades (
id				int				auto_increment		primary key,
idProvider		int				not null			references student(id),
idMatter		int				not null			references matter(id),
teacher			varchar(40)		not null,
dateCreation	date			default(SYSDATE())
);

insert into student (name, cpf, email, registration, login, password) values ('admin', '123', 'admin', 123, 'admin', '123');
