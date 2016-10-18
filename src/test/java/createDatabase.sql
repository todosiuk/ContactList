CREATE DATABASE IF NOT EXISTS  contact CHARACTER SET utf8 COLLATE utf8_general_ci;
USE contact;

CREATE TABLE IF NOT EXISTS store (
  Idstore  INT NOT NULL AUTO_INCREMENT,
  city VARCHAR(45) NOT NULL,
  PRIMARY KEY (idstore));



CREATE TABLE IF NOT EXISTS department (
  iddepartment INT NOT NULL AUTO_INCREMENT   PRIMARY KEY,
  name VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  phone VARCHAR(45) NULL,
  post VARCHAR(45) NULL,
  store_idstore INT NOT NULL,
    FOREIGN KEY (store_idstore)   REFERENCES store (idstore));
