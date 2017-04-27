-- DROP DATABASE ControlePredial;
CREATE DATABASE IF NOT EXISTS ControlePredial ;
USE ControlePredial;

CREATE TABLE Empresa
(
	cnpj CHAR(14) NOT NULL,
	razaoSocial VARCHAR(45) NOT NULL,
	endereco VARCHAR(45) NOT NULL,
	telefone VARCHAR(45) NOT NULL,
	horarioAbertura TIME NOT NULL,
	horarioFechamento TIME NOT NULL,
	PRIMARY KEY ( cnpj ),
	UNIQUE INDEX cnpj_UNIQUE ( cnpj ASC ) 
)
ENGINE = InnoDB;


 CREATE TABLE Funcionario
 (
  cpf CHAR(11) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  dataNascimento DATE NOT NULL,
  endereco VARCHAR(45) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  Empresa_cnpj CHAR(14) NULL,
  PRIMARY KEY ( cpf ),
  UNIQUE INDEX cpf_UNIQUE ( cpf ASC),
  INDEX fk_Funcionario_Empresa_idx ( Empresa_cnpj ASC),
  CONSTRAINT fk_Funcionario_Empresa
    FOREIGN KEY ( Empresa_cnpj )
    REFERENCES Empresa ( cnpj )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;

CREATE TABLE ControleTemperatura
(
  id INT NOT NULL AUTO_INCREMENT,
  temperaturaMaxima TINYINT(2) NOT NULL,
  horarioInicio TIME NOT NULL,
  horarioFim TIME NOT NULL,
  Empresa_cnpj CHAR(14) NOT NULL,
  PRIMARY KEY ( id ),
  UNIQUE INDEX id_UNIQUE ( id ASC),
  INDEX fk_ControleTemperatura_Empresa1_idx ( Empresa_cnpj ASC ),
  CONSTRAINT fk_ControleTemperatura_Empresa1
  FOREIGN KEY ( Empresa_cnpj )
  REFERENCES Empresa ( cnpj )
  ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;

CREATE TABLE Login
(
  Funcionario_cpf CHAR(11) NOT NULL,
  perfil TINYINT(1) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  alteraTemperatura  BOOLEAN NULL,
  livreAcesso BOOLEAN NOT NULL,
  horarioAcessoInicial TIME NULL,
  horarioAcessoFinal TIME NULL,
  INDEX fk_Login_Funcionario1_idx ( Funcionario_cpf ASC),
  PRIMARY KEY ( Funcionario_cpf ),
  CONSTRAINT fk_Login_Funcionario1
    FOREIGN KEY ( Funcionario_cpf )
    REFERENCES Funcionario( cpf )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;

CREATE TABLE ControleAcesso
(
  id INT NOT NULL AUTO_INCREMENT,
  horarioEntrada TIME NOT NULL,
  horarioSaida TIME NOT NULL,
  Login_Funcionario_cpf CHAR(11) NOT NULL,
  PRIMARY KEY ( id ),
  UNIQUE INDEX id_UNIQUE ( id ASC),
  INDEX fk_ControleAcesso_Login1_idx ( Login_Funcionario_cpf ASC),
  CONSTRAINT fk_ControleAcesso_Login1
    FOREIGN KEY ( Login_Funcionario_cpf )
    REFERENCES Login ( Funcionario_cpf )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;

CREATE TABLE Conjunto
 (
    id INT NOT NULL AUTO_INCREMENT,
    disponibilidade BOOLEAN NOT NULL,
    Empresa_cnpj CHAR(14) NULL,
    PRIMARY KEY ( id ),
    INDEX fk_Conjunto_Empresa1_idx ( Empresa_cnpj ASC),
    CONSTRAINT fk_Conjunto_Empresa1 FOREIGN KEY ( Empresa_cnpj )
        REFERENCES Empresa  ( cnpj )
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  
ENGINE=INNODB;

insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );
insert into Conjunto ( disponibilidade , Empresa_cnpj ) values ( true , null );


SELECT * FROM CONJUNTO;

USE CONTROLEPREDIAL;

SELECT * FROM EMPRESA;
SELECT * FROM CONTROLETEMPERATURA;