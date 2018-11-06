-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SistemaDeActivosBD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SistemaDeActivosBD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SistemaDeActivosBD` DEFAULT CHARACTER SET utf8 ;
USE `SistemaDeActivosBD` ;

-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Usuario` (
  `id` VARCHAR(10) NOT NULL,
  `funcionario` INT NULL DEFAULT NULL,
  `rol` INT NULL DEFAULT NULL,
  `clave` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Funcionario1_idx` (`funcionario` ASC) VISIBLE,
  INDEX `fk_Usuario_Rol1_idx` (`rol` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Funcionario1`
    FOREIGN KEY (`funcionario`)
    REFERENCES `SistemaDeActivosBD`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Rol1`
    FOREIGN KEY (`rol`)
    REFERENCES `SistemaDeActivosBD`.`Rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Dependencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Dependencia` (
  `descripcion` VARCHAR(25) NOT NULL,
  `administrador` INT NULL DEFAULT NULL,
  INDEX `fk_Dependencia_Funcionario1_idx` (`administrador` ASC) VISIBLE,
  PRIMARY KEY (`descripcion`),
  CONSTRAINT `fk_Dependencia_Funcionario1`
    FOREIGN KEY (`administrador`)
    REFERENCES `SistemaDeActivosBD`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Puesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Puesto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `funcionario` INT NULL DEFAULT NULL,
  `rol` INT NULL DEFAULT NULL,
  `dependencia` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Puesto_Funcionario1_idx` (`funcionario` ASC) VISIBLE,
  INDEX `fk_Puesto_Rol1_idx` (`rol` ASC) VISIBLE,
  INDEX `fk_Puesto_Dependencia1_idx` (`dependencia` ASC) VISIBLE,
  CONSTRAINT `fk_Puesto_Funcionario1`
    FOREIGN KEY (`funcionario`)
    REFERENCES `SistemaDeActivosBD`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Puesto_Rol1`
    FOREIGN KEY (`rol`)
    REFERENCES `SistemaDeActivosBD`.`Rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Puesto_Dependencia1`
    FOREIGN KEY (`dependencia`)
    REFERENCES `SistemaDeActivosBD`.`Dependencia` (`descripcion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Adquisicion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Adquisicion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Estado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Solicitud` (
  `fecha` DATE NOT NULL,
  `cantidad_bienes` INT NULL,
  `monto_total` DOUBLE NULL,
  `rechazo` VARCHAR(45) NOT NULL,
  `adquisicion` INT NULL DEFAULT NULL,
  `estado` INT NULL DEFAULT NULL,
  `comprobante` VARCHAR(45) NOT NULL,
  `registrador` INT NULL DEFAULT NULL,
  `dependencia` VARCHAR(25) NULL DEFAULT NULL,
  INDEX `fk_Solicitud_Adquisicion1_idx` (`adquisicion` ASC) VISIBLE,
  INDEX `fk_Solicitud_Estado1_idx` (`estado` ASC) VISIBLE,
  PRIMARY KEY (`comprobante`),
  INDEX `fk_Solicitud_Funcionario1_idx` (`registrador` ASC) VISIBLE,
  INDEX `fk_Solicitud_Dependencia1_idx` (`dependencia` ASC) VISIBLE,
  CONSTRAINT `fk_Solicitud_Adquisicion1`
    FOREIGN KEY (`adquisicion`)
    REFERENCES `SistemaDeActivosBD`.`Adquisicion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_Estado1`
    FOREIGN KEY (`estado`)
    REFERENCES `SistemaDeActivosBD`.`Estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_Funcionario1`
    FOREIGN KEY (`registrador`)
    REFERENCES `SistemaDeActivosBD`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_Dependencia1`
    FOREIGN KEY (`dependencia`)
    REFERENCES `SistemaDeActivosBD`.`Dependencia` (`descripcion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Bien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Bien` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(25) NOT NULL,
  `modelo` VARCHAR(25) NOT NULL,
  `precio_unitario` DOUBLE NOT NULL,
  `cantidad` INT NULL,
  `categoria` INT NULL DEFAULT NULL,
  `solicitud` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Bien_Categoria1_idx` (`categoria` ASC) VISIBLE,
  INDEX `fk_Bien_Solicitud1_idx` (`solicitud` ASC) VISIBLE,
  CONSTRAINT `fk_Bien_Categoria1`
    FOREIGN KEY (`categoria`)
    REFERENCES `SistemaDeActivosBD`.`Categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bien_Solicitud1`
    FOREIGN KEY (`solicitud`)
    REFERENCES `SistemaDeActivosBD`.`Solicitud` (`comprobante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaDeActivosBD`.`Activo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaDeActivosBD`.`Activo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bien` INT NULL DEFAULT NULL,
  `puesto` INT NULL DEFAULT NULL,
  `encargado` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Activo_Bien1_idx` (`bien` ASC) VISIBLE,
  INDEX `fk_Activo_Puesto1_idx` (`puesto` ASC) VISIBLE,
  INDEX `fk_Activo_Funcionario1_idx` (`encargado` ASC) VISIBLE,
  CONSTRAINT `fk_Activo_Bien1`
    FOREIGN KEY (`bien`)
    REFERENCES `SistemaDeActivosBD`.`Bien` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activo_Puesto1`
    FOREIGN KEY (`puesto`)
    REFERENCES `SistemaDeActivosBD`.`Puesto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Activo_Funcionario1`
    FOREIGN KEY (`encargado`)
    REFERENCES `SistemaDeActivosBD`.`Funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into Rol (descripcion) values ('Jefe OCCB');
insert into Rol (descripcion) values ('Jefe RRHH');
insert into Rol (descripcion) values ('Registrador');
insert into Rol (descripcion) values ('Secretaria');
insert into Rol (descripcion) values ('Administrador');

insert into Adquisicion (descripcion) values ('Donacion');
insert into Adquisicion (descripcion) values ('Compra');
insert into Adquisicion (descripcion) values ('Traslado');
insert into Adquisicion (descripcion) values ('Elaboracion Propia');

insert into Estado (descripcion) values ('Rechazada');
insert into Estado (descripcion) values ('Recibida');
insert into Estado (descripcion) values ('Por Verificar');
insert into Estado (descripcion) values ('En Espera');
insert into Estado (descripcion) values ('Procesada');

insert into Categoria (descripcion) values ('Indefinido');

insert into Usuario (id, Funcionario, rol, clave) values ('001', 1, 5, '001');

insert into Funcionario (nombre) values ('Figueres');

insert into Dependencia (descripcion, administrador) values ('Escuela de Informatica', 1);
