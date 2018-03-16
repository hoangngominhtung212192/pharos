-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pharos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pharos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pharos` DEFAULT CHARACTER SET utf8 ;
USE `pharos` ;

-- -----------------------------------------------------
-- Table `pharos`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`account` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `roleID` INT(11) NOT NULL,
  `enable` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `id_idx` (`roleID` ASC),
  CONSTRAINT `FK_Account_Role`
    FOREIGN KEY (`roleID`)
    REFERENCES `pharos`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`author` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `accountID` INT(11) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `tel` VARCHAR(20) NOT NULL,
  `cardNo` INT(11) NOT NULL,
  `frontCardImg` VARCHAR(255) NOT NULL,
  `backCardImg` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `avatar` VARCHAR(255) NOT NULL,
  `motto` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Author_Account_idx` (`accountID` ASC),
  CONSTRAINT `FK_Author_Account`
    FOREIGN KEY (`accountID`)
    REFERENCES `pharos`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`language`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`language` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `viewCount` INT(11) NOT NULL,
  `price` FLOAT NOT NULL,
  `languageID` INT(11) NOT NULL,
  `statusID` INT(11) NOT NULL,
  `voteCount` INT(11) NOT NULL,
  `publisherID` INT(11) NOT NULL,
  `pdf` VARCHAR(255) NOT NULL,
  `publishedDate` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Book_Language_idx` (`languageID` ASC),
  INDEX `FK_Book_Status_idx` (`statusID` ASC),
  INDEX `FK_Book_Author_idx` (`publisherID` ASC),
  CONSTRAINT `FK_Book_Author`
    FOREIGN KEY (`publisherID`)
    REFERENCES `pharos`.`author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Book_Language`
    FOREIGN KEY (`languageID`)
    REFERENCES `pharos`.`language` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Book_Status`
    FOREIGN KEY (`statusID`)
    REFERENCES `pharos`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`booktype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`booktype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `bookID` INT(11) NOT NULL,
  `typeID` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`member` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `accountID` INT(11) NOT NULL,
  `fullName` VARCHAR(255) NOT NULL,
  `brithday` DATE NULL DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL,
  `avatar` VARCHAR(255) NULL DEFAULT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `money` FLOAT NOT NULL,
  `tel` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `FK_Member_Account_idx` (`accountID` ASC),
  CONSTRAINT `FK_Member_Account`
    FOREIGN KEY (`accountID`)
    REFERENCES `pharos`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`favorite` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `memberID` INT(11) NOT NULL,
  `bookID` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Favorite_Member_idx` (`memberID` ASC),
  INDEX `FK_Favorite_Book_idx` (`bookID` ASC),
  CONSTRAINT `FK_Favorite_Book`
    FOREIGN KEY (`bookID`)
    REFERENCES `pharos`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Favorite_Member`
    FOREIGN KEY (`memberID`)
    REFERENCES `pharos`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`store` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `memberID` INT(11) NOT NULL,
  `bookID` INT(11) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `purchasedDate` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Store_Member_idx` (`memberID` ASC),
  INDEX `FK_Store_Book_idx` (`bookID` ASC),
  CONSTRAINT `FK_Store_Book`
    FOREIGN KEY (`bookID`)
    REFERENCES `pharos`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Store_Member`
    FOREIGN KEY (`memberID`)
    REFERENCES `pharos`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`transaction` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `memberID` INT(11) NOT NULL,
  `bookID` INT(11) NOT NULL,
  `purchasedDate` DATETIME NOT NULL,
  `difference` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Transaction_Member_idx` (`memberID` ASC),
  INDEX `FK_Transaction_Book_idx` (`bookID` ASC),
  CONSTRAINT `FK_Transaction_Book`
    FOREIGN KEY (`bookID`)
    REFERENCES `pharos`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Transaction_Member`
    FOREIGN KEY (`memberID`)
    REFERENCES `pharos`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pharos`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharos`.`type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
