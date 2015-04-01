-- MySQL Script generated by MySQL Workbench
-- 03/31/15 21:55:50
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Refugiate
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Empresa` ;

CREATE TABLE IF NOT EXISTS `Empresa` (
  `idEmpresa` INT NOT NULL,
  `nombreComercial` VARCHAR(150) NULL,
  `nombre` VARCHAR(150) NULL,
  `slogan` VARCHAR(150) NULL,
  `ruc` VARCHAR(11) NULL,
  `estado` INT NULL,
  `puntos` INT NULL,
  `fechaRegistro` DATETIME NULL,
  `logo` BLOB NULL,
  `banner` BLOB NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Persona` ;

CREATE TABLE IF NOT EXISTS `Persona` (
  `idPersona` INT NOT NULL,
  `nombres` VARCHAR(200) NULL,
  `apellidos` VARCHAR(200) NULL,
  `telefono` VARCHAR(25) NULL,
  `email` VARCHAR(150) NULL,
  `dni` VARCHAR(8) NULL,
  `usuario` VARCHAR(50) NULL,
  `password` VARCHAR(50) NULL,
  `informacion` VARCHAR(150) NULL,
  `puntualidad` INT NULL,
  `honrades` INT NULL,
  `educacion` INT NULL,
  `calificacion` INT NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB
COMMENT = '		';


-- -----------------------------------------------------
-- Table `BajaEmpresaPersona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BajaEmpresaPersona` ;

CREATE TABLE IF NOT EXISTS `BajaEmpresaPersona` (
  `idBajaEmpresaPersona` INT NOT NULL,
  `idEmpresa` INT NULL,
  `idPersona` INT NULL,
  `comentario` VARCHAR(250) NULL,
  `fechaRegistro` DATETIME NULL,
  `fechaFinal` DATETIME NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idBajaEmpresaPersona`),
  INDEX `fk_BajaEmpresaPersona_Empresa1_idx` (`idEmpresa` ASC),
  INDEX `fk_BajaEmpresaPersona_Persona1_idx` (`idPersona` ASC),
  CONSTRAINT `fk_BajaEmpresaPersona_Empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BajaEmpresaPersona_Persona1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Departamento` ;

CREATE TABLE IF NOT EXISTS `Departamento` (
  `idDepartamento` INT NOT NULL,
  `nombre` VARCHAR(50) NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `Provincia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Provincia` ;

CREATE TABLE IF NOT EXISTS `Provincia` (
  `idProvincia` INT NOT NULL,
  `idDepartamento` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idProvincia`),
  INDEX `fk_Provincia_Departamento1_idx` (`idDepartamento` ASC),
  CONSTRAINT `fk_Provincia_Departamento1`
    FOREIGN KEY (`idDepartamento`)
    REFERENCES `Departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Distrito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Distrito` ;

CREATE TABLE IF NOT EXISTS `Distrito` (
  `idDistrito` INT NOT NULL,
  `idProvincia` INT NOT NULL,
  `nombre` VARCHAR(50) NULL,
  PRIMARY KEY (`idDistrito`),
  INDEX `fk_Distrito_Provincia1_idx` (`idProvincia` ASC),
  CONSTRAINT `fk_Distrito_Provincia1`
    FOREIGN KEY (`idProvincia`)
    REFERENCES `Provincia` (`idProvincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '		';


-- -----------------------------------------------------
-- Table `Sucursal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Sucursal` ;

CREATE TABLE IF NOT EXISTS `Sucursal` (
  `idSucursal` INT NOT NULL,
  `idEmpresa` INT NULL,
  `idDistrito` INT NULL,
  `direccion` VARCHAR(150) NULL,
  `pisos` INT NULL,
  `telefono` VARCHAR(25) NULL,
  `longitud` DECIMAL(18,15) NULL,
  `latitud` DECIMAL(18,15) NULL,
  `limpieza` INT NULL,
  `servicio` INT NULL,
  `comodidad` INT NULL,
  `puntuacion` INT NULL,
  `nivel` INT NULL,
  `entrada` VARCHAR(10) NULL,
  `salida` VARCHAR(10) NULL,
  `fecha` DATETIME NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idSucursal`),
  INDEX `fk_Sucursal_Distrito1_idx` (`idDistrito` ASC),
  INDEX `fk_Sucursal_Empresa1_idx` (`idEmpresa` ASC),
  CONSTRAINT `fk_Sucursal_Distrito1`
    FOREIGN KEY (`idDistrito`)
    REFERENCES `Distrito` (`idDistrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sucursal_Empresa1`
    FOREIGN KEY (`idEmpresa`)
    REFERENCES `Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Reserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Reserva` ;

CREATE TABLE IF NOT EXISTS `Reserva` (
  `idReserva` INT NOT NULL,
  `idPersona` INT NULL,
  `idSucursal` INT NULL,
  `fechaRegistro` DATETIME NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idReserva`),
  INDEX `fk_Reserva_Persona1_idx` (`idPersona` ASC),
  INDEX `fk_Reserva_Sucursal1_idx` (`idSucursal` ASC),
  CONSTRAINT `fk_Reserva_Persona1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Sucursal1`
    FOREIGN KEY (`idSucursal`)
    REFERENCES `Sucursal` (`idSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Comentario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Comentario` ;

CREATE TABLE IF NOT EXISTS `Comentario` (
  `idComentario` INT NOT NULL,
  `idReserva` INT NULL,
  `descripcion` VARCHAR(250) NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`idComentario`),
  INDEX `fk_Comentario_Reserva1_idx` (`idReserva` ASC),
  CONSTRAINT `fk_Comentario_Reserva1`
    FOREIGN KEY (`idReserva`)
    REFERENCES `Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TipoHabitacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TipoHabitacion` ;

CREATE TABLE IF NOT EXISTS `TipoHabitacion` (
  `idTipoHabitacion` INT NOT NULL,
  `nombreComercial` VARCHAR(150) NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idTipoHabitacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CostoTipoHabitacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CostoTipoHabitacion` ;

CREATE TABLE IF NOT EXISTS `CostoTipoHabitacion` (
  `idCostoTipoHabitacion` INT NOT NULL,
  `isTipoHabitacion` INT NULL,
  `idSucursal` INT NULL,
  `costo` DECIMAL(10,2) NULL,
  `totalHabitaicones` INT NULL,
  `habitacionesOcupadas` INT NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idCostoTipoHabitacion`),
  INDEX `fk_CostoTipoHabitacion_TipoHabitacion1_idx` (`isTipoHabitacion` ASC),
  INDEX `fk_CostoTipoHabitacion_Sucursal1_idx` (`idSucursal` ASC),
  CONSTRAINT `fk_CostoTipoHabitacion_TipoHabitacion1`
    FOREIGN KEY (`isTipoHabitacion`)
    REFERENCES `TipoHabitacion` (`idTipoHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CostoTipoHabitacion_Sucursal1`
    FOREIGN KEY (`idSucursal`)
    REFERENCES `Sucursal` (`idSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Habitacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Habitacion` ;

CREATE TABLE IF NOT EXISTS `Habitacion` (
  `idHabitacion` INT NOT NULL,
  `idCostoTipoHabitacion` INT NULL,
  `numero` INT NULL,
  `piso` INT NULL,
  `numeroPersonas` INT NULL,
  `estado` INT NULL,
  `vista` BIT NULL,
  PRIMARY KEY (`idHabitacion`),
  INDEX `fk_Habitacion_CostoTipoHabitacion1_idx` (`idCostoTipoHabitacion` ASC),
  CONSTRAINT `fk_Habitacion_CostoTipoHabitacion1`
    FOREIGN KEY (`idCostoTipoHabitacion`)
    REFERENCES `CostoTipoHabitacion` (`idCostoTipoHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DetalleReserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DetalleReserva` ;

CREATE TABLE IF NOT EXISTS `DetalleReserva` (
  `idDetalleReserva` INT NOT NULL,
  `idReserva` INT NULL,
  `numeroHabitaciones` INT NULL,
  `fechaIngresp` DATETIME NULL,
  `dias` INT NULL,
  `total` DECIMAL(10,2) NULL,
  `estado` INT NULL,
  `idHabitacion` INT NOT NULL,
  PRIMARY KEY (`idDetalleReserva`),
  INDEX `fk_DetalleReserva_Reserva1_idx` (`idReserva` ASC),
  INDEX `fk_DetalleReserva_Habitacion1_idx` (`idHabitacion` ASC),
  CONSTRAINT `fk_DetalleReserva_Reserva1`
    FOREIGN KEY (`idReserva`)
    REFERENCES `Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleReserva_Habitacion1`
    FOREIGN KEY (`idHabitacion`)
    REFERENCES `Habitacion` (`idHabitacion`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Encargado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Encargado` ;

CREATE TABLE IF NOT EXISTS `Encargado` (
  `idEncargado` INT NOT NULL,
  `idSucursal` INT NULL,
  `nombre` VARCHAR(150) NULL,
  `apellido` VARCHAR(150) NULL,
  `email` VARCHAR(150) NULL,
  `celularPersonal` VARCHAR(15) NULL,
  `usuario` VARCHAR(150) NULL,
  `password` VARCHAR(50) NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idEncargado`),
  INDEX `fk_Encargado_Sucursal1_idx` (`idSucursal` ASC),
  CONSTRAINT `fk_Encargado_Sucursal1`
    FOREIGN KEY (`idSucursal`)
    REFERENCES `Sucursal` (`idSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Servicio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Servicio` ;

CREATE TABLE IF NOT EXISTS `Servicio` (
  `idServicio` INT NOT NULL,
  `nombre` VARCHAR(150) NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idServicio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Instalacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Instalacion` ;

CREATE TABLE IF NOT EXISTS `Instalacion` (
  `idInstalacion` INT NOT NULL,
  `idServicio` INT NULL,
  `idSucursal` INT NULL,
  `descripcion` TEXT NULL,
  PRIMARY KEY (`idInstalacion`),
  INDEX `fk_Instalacion_Servicio1_idx` (`idServicio` ASC),
  INDEX `fk_Instalacion_Sucursal1_idx` (`idSucursal` ASC),
  CONSTRAINT `fk_Instalacion_Servicio1`
    FOREIGN KEY (`idServicio`)
    REFERENCES `Servicio` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Instalacion_Sucursal1`
    FOREIGN KEY (`idSucursal`)
    REFERENCES `Sucursal` (`idSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PuntuacionHotel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PuntuacionHotel` ;

CREATE TABLE IF NOT EXISTS `PuntuacionHotel` (
  `idPuntuacionHotel` INT NOT NULL,
  `idReserva` INT NULL,
  `limpieza` INT NULL,
  `servicio` INT NULL,
  `comodidad` INT NULL,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`idPuntuacionHotel`),
  INDEX `fk_Puntuacion_Reserva1_idx` (`idReserva` ASC),
  CONSTRAINT `fk_Puntuacion_Reserva1`
    FOREIGN KEY (`idReserva`)
    REFERENCES `Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WebAdmin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `WebAdmin` ;

CREATE TABLE IF NOT EXISTS `WebAdmin` (
  `idWebAdmin` INT NOT NULL,
  `nombre` VARCHAR(200) NULL,
  `apellido` VARCHAR(200) NULL,
  `usuario` VARCHAR(50) NULL,
  `password` VARCHAR(50) NULL,
  `nivel` INT NULL,
  `email` VARCHAR(150) NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idWebAdmin`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PuntuacionUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PuntuacionUsuario` ;

CREATE TABLE IF NOT EXISTS `PuntuacionUsuario` (
  `idPuntuacionUsuario` INT NOT NULL,
  `puntualidad` INT NULL,
  `honrades` INT NULL,
  `educacion` INT NULL,
  `fecha` DATETIME NULL,
  `idReserva` INT NOT NULL,
  PRIMARY KEY (`idPuntuacionUsuario`),
  INDEX `fk_CalificacionUsuario_Reserva1_idx` (`idReserva` ASC),
  CONSTRAINT `fk_CalificacionUsuario_Reserva1`
    FOREIGN KEY (`idReserva`)
    REFERENCES `Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Promociones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Promociones` ;

CREATE TABLE IF NOT EXISTS `Promociones` (
  `idPromociones` INT NOT NULL,
  `dato` VARCHAR(45) NULL,
  `fechaInicio` DATETIME NULL,
  `fechaFin` DATETIME NULL,
  `estado` VARCHAR(45) NULL,
  `idSucursal` INT NOT NULL,
  PRIMARY KEY (`idPromociones`),
  INDEX `fk_Promociones_Sucursal1_idx` (`idSucursal` ASC),
  CONSTRAINT `fk_Promociones_Sucursal1`
    FOREIGN KEY (`idSucursal`)
    REFERENCES `Sucursal` (`idSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Placeholder table for view `view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `view1` (`id` INT);

-- -----------------------------------------------------
-- View `view1`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `view1` ;
DROP TABLE IF EXISTS `view1`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
