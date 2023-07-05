-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mysql06
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mysql06
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mysql06` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mysql06` ;

-- -----------------------------------------------------
-- Table `mysql06`.`member0630`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mysql06`.`member0630` (
  `member_id` BIGINT NOT NULL AUTO_INCREMENT,
  `member_name` VARCHAR(100) NOT NULL,
  `member_password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`member_id`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mysql06`.`board0630`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mysql06`.`board0630` (
  `board_id` BIGINT NOT NULL AUTO_INCREMENT,
  `board_title` VARCHAR(100) NOT NULL,
  `board_content` VARCHAR(255) NOT NULL,
  `board_writer` VARCHAR(100) NOT NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`board_id`),
  INDEX `board_writer` (`board_writer` ASC) VISIBLE,
  CONSTRAINT `board0630_ibfk_1`
    FOREIGN KEY (`board_writer`)
    REFERENCES `mysql06`.`member0630` (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
