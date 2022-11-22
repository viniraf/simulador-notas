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

create table grades (
id				int				auto_increment		primary key,
idStudent		int				not null			references student(id),
nameMatter		varchar(50)		not null,
noteAc1			float(4,2)		default(0),
ac1Multiplier	float(4,2)		default(1),
noteAc2			float(4,2)		default(0),
ac2Multiplier	float(4,2)		default(1),
noteAf			float(4,2)		default(0),
afMultiplier	float(4,2)		default(1),
noteSub			float(4,2)		default(0),
subMultiplier	float(4,2)		default(1),
noteAg			float(4,2)		default(0),
agMultiplier	float(4,2)		default(1)
);

insert into student (name, cpf, email, registration, login, password) values ('admin', '123', 'admin', 123, 'admin', '123'), ('admin2', '1234', 'admin2', 1234, 'admin2', '1234');
