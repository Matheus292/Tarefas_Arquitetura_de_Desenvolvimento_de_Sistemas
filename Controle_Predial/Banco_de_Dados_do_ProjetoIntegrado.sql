drop database if exists projetoIntegrado;


show databases;

create database ProjetoIntegrado;


use ProjetoIntegrado;

show tables;


create table Empresa 
(
  cnpj char(14) not null unique key,
  razaoSocial varchar(45) not null,
  telefone varchar(45) not null,
  endereco varchar(45) not null,
  horarioAbertura time not null,
  horarioFechamento time not null,
  
  primary key (cnpj)
  );


create table Funcionario
(
  cpf char(11) not null unique key,
  nome varchar(45) not null,
  endereco varchar(45) not null,
  telefone varchar( 20 ) not null,
  dataNascimento date not null,   
  horarioEntradaMinima time null,
  horarioEntradaMaxima time null,
  alteraTemperatura boolean not null,
  Empresa_cnpj char(14) null,
  
	primary key (cpf)
);


create table Login
(
  Funcionario_cpf char(11) not null unique key,
  senha varchar(45) not null,  
  perfil char(1) not null,
  livreAcesso Boolean not null,
  
  PRIMARY KEY (Funcionario_cpf),
  INDEX Login_Funcionario ( funcionario_cpf ASC)
  );


 create table ControleDeAcesso
 (
  idControleDeAcesso int not null auto_increment,
  horarioEntrada time not null,
  horarioSaida time not null,
  Login_Funcionario_cpf char(11) not null,
  PRIMARY KEY (idControleDeAcesso),
  INDEX ControleDeAcesso_Login ( login_funcionario_cpf ASC)
 );


create table Conjunto
 (
  idConjunto int not null auto_increment,
  disponivel boolean not null,
  Empresa_cnpj char(14) null,
  
  PRIMARY KEY (idConjunto)
  );


create table ControleArCondicionado 
(
 idControleArCondicionado int not null auto_increment,
  inicioFuncionamento time not null,
  fimFuncionamento time not null,
  temperaturaPadrao tinyint not null,
  Empresa_cnpj char(14) not null,
  PRIMARY KEY ( idControleArCondicionado )
  );
  
  
  
alter table Funcionario add
constraint Funcionario_fk_Empresa

foreign key(Empresa_cnpj)
references Empresa(cnpj)
on update no action
on delete no action;


alter table Login add
constraint Login_fk_Funcionario
foreign key(Funcionario_cpf)
references Funcionario(cpf)
on update no action
on delete no action;


alter table Conjunto add
constraint Conjunto_fk_Empresa
foreign key(Empresa_cnpj)
references Empresa(cnpj)
on update no action
on delete no action;


alter table ControleDeAcesso add
constraint ControleDeAcesso_fk_Login
foreign key( Login_Funcionario_cpf )
references Login(Funcionario_cpf)
on update no action
on delete no action;


alter table ControleArCondicionado add
constraint ControleArCondionado_fk_Empresa
foreign key( Empresa_cnpj )
references Empresa(cnpj)
on delete no action
on update no action;


insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );
insert into Conjunto ( disponivel ) values ( true );

use ProjetoIntegrado;


select * from conjunto where disponivel = true;

select * from controlearcondicionado;

select * from Empresa;

insert into Empresa ( cnpj , razaoSocial , telefone , endereco , horarioAbertura , horarioFechamento )
 values ( '23456789012345' , 'Não sei' , ' ( 11 ) 0000 - 0000' , ' Rua dos bobos, 0 '  , now( ) , now( ) );


select e.cnpj , e.razaoSocial , e.telefone , e.endereco , 
e.horarioAbertura , e.horarioFechamento , t.inicioFuncionamento ,t.fimFuncionamento,t.temperaturaPadrao from Empresa e 
 inner join controlearcondicionado t on e.cnpj = t.Empresa_cnpj;


