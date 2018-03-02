create database academia;

create table instrutor(
	cpf varchar(11),
    nome varchar(255) not null,
    email varchar(255) not null,
    sexo boolean not null,
    cargo varchar(50),
    primary key(cpf)
);

create table aluno(
	cpf varchar(11),
    nome varchar(255) not null,
    email varchar(255) not null,
    sexo boolean not null,
    nota float not null,
    presenca boolean not null,
    aprovacao boolean not null,
    id_academia int not null,
    primary key(cpf),
	CONSTRAINT `fk_academia` FOREIGN KEY ( `id_academia` ) REFERENCES `academia` ( `id_academia` )
);

create table academia(
	id_academia int auto_increment,
	status varchar(15) not null,
    tipo varchar(255) not null,
    data_inicio date not null,
    data_final date not null,
	hora_inicio varchar(20) not null,
    hora_final varchar(20) not null,
    sala varchar(50) not null,
    predio varchar(50) not null,
    cpf_instrutor varchar(11) not null,
    primary key(id_academia),
    CONSTRAINT `fk_instrutor` FOREIGN KEY ( `cpf_instrutor` ) REFERENCES `instrutor` ( `cpf` )
);
