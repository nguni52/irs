SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `irs` ;
CREATE SCHEMA IF NOT EXISTS `irs` DEFAULT CHARACTER SET latin1 ;
USE `irs` ;

-- -----------------------------------------------------
-- Table `irs`.`job_title`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`job_title` ;

CREATE  TABLE IF NOT EXISTS `irs`.`job_title` (
  `job_title_id` INT NOT NULL AUTO_INCREMENT ,
  `job_title_description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`job_title_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`gender` ;

CREATE  TABLE IF NOT EXISTS `irs`.`gender` (
  `gender_id` INT NOT NULL AUTO_INCREMENT ,
  `dender_description` VARCHAR(6) NOT NULL ,
  PRIMARY KEY (`gender_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`title`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`title` ;

CREATE  TABLE IF NOT EXISTS `irs`.`title` (
  `title_id` INT NOT NULL AUTO_INCREMENT ,
  `title_description` VARCHAR(4) NOT NULL ,
  PRIMARY KEY (`title_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`person` ;

CREATE  TABLE IF NOT EXISTS `irs`.`person` (
  `person_id` INT NOT NULL AUTO_INCREMENT ,
  `job_title_id` INT NOT NULL ,
  `gender_id` INT NOT NULL ,
  `title_id` INT NOT NULL ,
  `identity_number` VARCHAR(13) NOT NULL ,
  `firstname` VARCHAR(45) NOT NULL ,
  `surname` VARCHAR(45) NOT NULL ,
  `work_number` VARCHAR(15) NULL ,
  `mobile_number` VARCHAR(15) NOT NULL ,
  `email_address` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`person_id`) ,
  INDEX `gender_id_idx` (`gender_id` ASC) ,
  INDEX `title_id_idx` (`title_id` ASC) ,
  INDEX `job_title_id_idx` (`job_title_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`investor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`investor` ;

CREATE  TABLE IF NOT EXISTS `irs`.`investor` (
  `investor_id` INT NOT NULL AUTO_INCREMENT ,
  `investor_description` VARCHAR(45) NOT NULL ,
  `contact_number` VARCHAR(15) NOT NULL ,
  `email_address` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`investor_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`trustee_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`trustee_role` ;

CREATE  TABLE IF NOT EXISTS `irs`.`trustee_role` (
  `trustee_role_id` INT NOT NULL AUTO_INCREMENT ,
  `trustee_role_description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`trustee_role_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`trustee_person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`trustee_person` ;

CREATE  TABLE IF NOT EXISTS `irs`.`trustee_person` (
  `trustee_role_id` INT NOT NULL ,
  `person_id` INT NOT NULL ,
  `date_from` DATE NOT NULL ,
  `date_to` DATE NULL ,
  `status` TINYINT NOT NULL ,
  INDEX `person_id_idx` (`person_id` ASC) ,
  INDEX `trustee_role_id_idx` (`trustee_role_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`postal_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`postal_address` ;

CREATE  TABLE IF NOT EXISTS `irs`.`postal_address` (
  `postal_address_id` INT NOT NULL AUTO_INCREMENT ,
  `number` VARCHAR(30) NOT NULL ,
  `suburb` VARCHAR(45) NOT NULL ,
  `postal_code` INT NOT NULL ,
  `status` TINYINT NOT NULL ,
  PRIMARY KEY (`postal_address_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`physical_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`physical_address` ;

CREATE  TABLE IF NOT EXISTS `irs`.`physical_address` (
  `physical_address_id` INT NOT NULL AUTO_INCREMENT ,
  `unit_number` INT NULL DEFAULT NULL ,
  `complex_name` VARCHAR(45) NULL DEFAULT NULL ,
  `street_number` INT NULL DEFAULT NULL ,
  `street_name` VARCHAR(45) NULL DEFAULT NULL ,
  `suburb` VARCHAR(45) NULL DEFAULT NULL ,
  `city` VARCHAR(45) NOT NULL ,
  `postal_code` INT NOT NULL ,
  `same_as_postal` TINYINT(1) NULL ,
  `status` TINYINT NOT NULL ,
  PRIMARY KEY (`physical_address_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`investor_person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`investor_person` ;

CREATE  TABLE IF NOT EXISTS `irs`.`investor_person` (
  `person_id` INT NOT NULL ,
  `investor_id` INT NOT NULL ,
  INDEX `investor_id_idx` (`investor_id` ASC) ,
  INDEX `person_id_idx` (`person_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`investor_postal_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`investor_postal_address` ;

CREATE  TABLE IF NOT EXISTS `irs`.`investor_postal_address` (
  `investor_id` INT NOT NULL ,
  `postal_address_id` INT NOT NULL ,
  INDEX `investor_id_idx` (`investor_id` ASC) ,
  INDEX `postal_address_is_idx` (`postal_address_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`investor_physical_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`investor_physical_address` ;

CREATE  TABLE IF NOT EXISTS `irs`.`investor_physical_address` (
  `investor_id` INT NOT NULL ,
  `physical_address_id` INT NOT NULL ,
  INDEX `investor_id_idx` (`investor_id` ASC) ,
  INDEX `physical_address_id_idx` (`physical_address_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`asset_manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`asset_manager` ;

CREATE  TABLE IF NOT EXISTS `irs`.`asset_manager` (
  `asset_manager_id` INT NOT NULL AUTO_INCREMENT ,
  `asset_manager_description` VARCHAR(45) NOT NULL ,
  `contact_number` VARCHAR(15) NOT NULL ,
  `email_address` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`asset_manager_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`asset_manager_postal_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`asset_manager_postal_address` ;

CREATE  TABLE IF NOT EXISTS `irs`.`asset_manager_postal_address` (
  `asset_manager_id` INT NOT NULL ,
  `postal_address_id` INT NOT NULL ,
  INDEX `postal_address_is_idx` (`postal_address_id` ASC) ,
  INDEX `asset_manager_id_idx` (`asset_manager_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`asset_manager_physical_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`asset_manager_physical_address` ;

CREATE  TABLE IF NOT EXISTS `irs`.`asset_manager_physical_address` (
  `asset_manager_id` INT NOT NULL ,
  `physical_address_id` INT NOT NULL ,
  INDEX `asset_manager_id_idx` (`asset_manager_id` ASC) ,
  INDEX `physical_address_id_idx` (`physical_address_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`users` ;

CREATE  TABLE IF NOT EXISTS `irs`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(20) NOT NULL ,
  `password` VARCHAR(15) NOT NULL ,
  `enabled` TINYINT NOT NULL ,
  PRIMARY KEY (`user_id`) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`authorities` ;

CREATE  TABLE IF NOT EXISTS `irs`.`authorities` (
  `username` VARCHAR(20) NOT NULL ,
  `authority` VARCHAR(10) NOT NULL ,
  INDEX `username_idx` (`username` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`asset_manager_person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`asset_manager_person` ;

CREATE  TABLE IF NOT EXISTS `irs`.`asset_manager_person` (
  `person_id` INT NOT NULL ,
  `asset_manager_id` INT NOT NULL ,
  INDEX `person_id_idx` (`person_id` ASC) ,
  INDEX `asset_manager_id_idx` (`asset_manager_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`portfolio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`portfolio` ;

CREATE  TABLE IF NOT EXISTS `irs`.`portfolio` (
  `portfolio_id` INT NOT NULL AUTO_INCREMENT ,
  `investor_id` INT NOT NULL ,
  `portfolio_description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`portfolio_id`) ,
  INDEX `investor_id_idx` (`investor_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irs`.`user_person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `irs`.`user_person` ;

CREATE  TABLE IF NOT EXISTS `irs`.`user_person` (
  `person_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  INDEX `person_id_idx` (`person_id` ASC) ,
  INDEX `user_is_idx` (`user_id` ASC) )
ENGINE = InnoDB;

USE `irs` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
