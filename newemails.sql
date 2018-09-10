-- MySQL Workbench Forward Engineering

DROP SCHEMA IF EXISTS `user` ;

CREATE SCHEMA IF NOT EXISTS `user` ;

USE `user`;

CREATE TABLE IF NOT EXISTS `user`.`user_email` (
  `email` VARCHAR(50) NOT NULL,
  `pib` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;

INSERT INTO `user`.`user_email` (email) VALUES ('klymenko.nastasia@gmail.com', 'Anastasiia Klymenko'), ('baksnaz@gmail.com', 'Nazarii Bakusko'), ('Anastasiia-Antonina_Klymenko@epam.com', 'Anastasiia Klymenko');

SELECT *
FROM `user`.`user_email`