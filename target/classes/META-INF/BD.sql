-- Sat Oct 13 16:19:30 2018
-- -----------------------------------------------------
-- Schema juzgado
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `juzgado` ;

-- -----------------------------------------------------
-- Schema juzgado
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `juzgado` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `juzgado` ;

-- -----------------------------------------------------
-- Table `juzgado`.`Ofendidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`Ofendidos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`Ofendidos` (
  `idOfendidos` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idOfendidos`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`Fallador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`Fallador` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`Fallador` (
  `idFallador` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL,
  PRIMARY KEY (`idFallador`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`Procesos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`Procesos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`Procesos` (
  `NI` INT NOT NULL,
  `FechaReparto` DATE NOT NULL,
  `FechaIngreso` DATE NOT NULL,
  `Numero` VARCHAR(50) NOT NULL,
  `NumeroCuadernos` INT NOT NULL,
  `Ofendidos_idOfendidos` INT NOT NULL,
  `Fallador1` INT NOT NULL,
  `fechaSentencia` DATE NOT NULL,
  `fechaSentencia2` DATE NOT NULL,
  `Fallador_idFallador1` INT NOT NULL,
  PRIMARY KEY (`NI`),
  CONSTRAINT `fk_Procesos_Ofendidos`
    FOREIGN KEY (`Ofendidos_idOfendidos`)
    REFERENCES `juzgado`.`Ofendidos` (`idOfendidos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Procesos_Fallador1`
    FOREIGN KEY (`Fallador1`)
    REFERENCES `juzgado`.`Fallador` (`idFallador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Procesos_Fallador2`
    FOREIGN KEY (`Fallador_idFallador1`)
    REFERENCES `juzgado`.`Fallador` (`idFallador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Procesos_Ofendidos_idx` ON `juzgado`.`Procesos` (`Ofendidos_idOfendidos` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_Procesos_Fallador1_idx` ON `juzgado`.`Procesos` (`Fallador1` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_Procesos_Fallador2_idx` ON `juzgado`.`Procesos` (`Fallador_idFallador1` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`Condenados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`Condenados` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`Condenados` (
  `identificacion` INT NOT NULL AUTO_INCREMENT,
  `nombreCondenado` VARCHAR(100) NOT NULL,
  `procesosAcumulados` VARCHAR(45) NULL,
  PRIMARY KEY (`identificacion`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`pena`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`pena` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`pena` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pena_prision` VARCHAR(50) NULL,
  `pena_multa` INT NULL,
  `Condenados_identificacion` INT NOT NULL,
  `Procesos_NI` INT NOT NULL,
  `procesoRequerido` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_delito_condenado_Condenados1`
    FOREIGN KEY (`Condenados_identificacion`)
    REFERENCES `juzgado`.`Condenados` (`identificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delito_condenado_Procesos1`
    FOREIGN KEY (`Procesos_NI`)
    REFERENCES `juzgado`.`Procesos` (`NI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_delito_condenado_Condenados1_idx` ON `juzgado`.`pena` (`Condenados_identificacion` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_delito_condenado_Procesos1_idx` ON `juzgado`.`pena` (`Procesos_NI` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`Delitos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`Delitos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`Delitos` (
  `idDelitos` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idDelitos`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`pena_delitos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`pena_delitos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`pena_delitos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Delitos_idDelitos` INT NOT NULL,
  `pena_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_pena_delitos_Delitos1`
    FOREIGN KEY (`Delitos_idDelitos`)
    REFERENCES `juzgado`.`Delitos` (`idDelitos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pena_delitos_pena1`
    FOREIGN KEY (`pena_id`)
    REFERENCES `juzgado`.`pena` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_pena_delitos_Delitos1_idx` ON `juzgado`.`pena_delitos` (`Delitos_idDelitos` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_pena_delitos_pena1_idx` ON `juzgado`.`pena_delitos` (`pena_id` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`situacion_juridica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`situacion_juridica` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`situacion_juridica` (
  `id_detenido_carcel` INT NOT NULL AUTO_INCREMENT,
  `fecha_captura` DATE NULL,
  `dias_adicionales_detencion` VARCHAR(45) NULL,
  `carcel` VARCHAR(200) NULL,
  `observaciones` VARCHAR(200) NULL,
  `lugar_cumplimiento` VARCHAR(100) NULL,
  `folio` VARCHAR(100) NULL,
  `tipo` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `fechaFinalizacion` DATE NULL,
  `fechaExtincion` DATE NULL,
  `pena_id` INT NOT NULL,
  PRIMARY KEY (`id_detenido_carcel`),
  CONSTRAINT `fk_situacion_juridica_pena1`
    FOREIGN KEY (`pena_id`)
    REFERENCES `juzgado`.`pena` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_situacion_juridica_pena1_idx` ON `juzgado`.`situacion_juridica` (`pena_id` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`redencion_penas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`redencion_penas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`redencion_penas` (
  `idredencion_penas` INT NOT NULL,
  `sancion` VARCHAR(100) NULL,
  `fecha_ejecutoria` DATE NULL,
  `dias` VARCHAR(45) NULL,
  `detenido_carcel_id_detenido_carcel` INT NOT NULL,
  PRIMARY KEY (`idredencion_penas`),
  CONSTRAINT `fk_redencion_penas_detenido_carcel1`
    FOREIGN KEY (`detenido_carcel_id_detenido_carcel`)
    REFERENCES `juzgado`.`situacion_juridica` (`id_detenido_carcel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_redencion_penas_detenido_carcel1_idx` ON `juzgado`.`redencion_penas` (`detenido_carcel_id_detenido_carcel` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`condiciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`condiciones` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`condiciones` (
  `idcondiciones` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(200) NULL,
  `detenido_id_detenido_carcel` INT NOT NULL,
  PRIMARY KEY (`idcondiciones`),
  CONSTRAINT `fk_condiciones_detenido1`
    FOREIGN KEY (`detenido_id_detenido_carcel`)
    REFERENCES `juzgado`.`situacion_juridica` (`id_detenido_carcel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_condiciones_detenido1_idx` ON `juzgado`.`condiciones` (`detenido_id_detenido_carcel` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `juzgado`.`caucion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `juzgado`.`caucion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `juzgado`.`caucion` (
  `idcaucion` INT NOT NULL AUTO_INCREMENT,
  `nDeposito` INT NULL,
  `valor` INT NULL,
  `fechaDevolucion` DATE NULL,
  `poliza` VARCHAR(45) NULL,
  `situacion_juridica_id_detenido_carcel` INT NOT NULL,
  PRIMARY KEY (`idcaucion`),
  CONSTRAINT `fk_caucion_situacion_juridica1`
    FOREIGN KEY (`situacion_juridica_id_detenido_carcel`)
    REFERENCES `juzgado`.`situacion_juridica` (`id_detenido_carcel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_caucion_situacion_juridica1_idx` ON `juzgado`.`caucion` (`situacion_juridica_id_detenido_carcel` ASC) VISIBLE;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
