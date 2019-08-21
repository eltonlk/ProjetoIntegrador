DROP TABLE IF EXISTS `projeto_integrador`.`users_roles`;
DROP TABLE IF EXISTS `projeto_integrador`.`users`;
DROP TABLE IF EXISTS `projeto_integrador`.`roles`;
DROP TABLE IF EXISTS `projeto_integrador`.`categories`;
DROP TABLE IF EXISTS `projeto_integrador`.`materials`;

CREATE TABLE `projeto_integrador`.`users` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `admin` BOOLEAN DEFAULT 0,
  `active` BOOLEAN DEFAULT 1
);

CREATE TABLE `projeto_integrador`.`roles` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL
);

CREATE TABLE `projeto_integrador`.`users_roles` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE `projeto_integrador`.`categories` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NULL
);

CREATE TABLE `projeto_integrador`.`materials` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL
);
