DROP DATABASE if exists ControlePredial;
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

CREATE TABLE Usuario
 (
  login VARCHAR( 50 ) NOT NULL,
  senha VARCHAR( 50 ) NOT NULL,
  PRIMARY KEY ( login ),
  UNIQUE INDEX login_UNIQUE ( login ASC)
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