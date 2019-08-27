DROP TABLE IF EXISTS audits;
DROP TABLE IF EXISTS options;

DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS materials;

DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE users (
  id serial PRIMARY KEY,
  name VARCHAR (255) UNIQUE NOT NULL,
  email VARCHAR (255) UNIQUE NOT NULL,
  username VARCHAR (255) UNIQUE NOT NULL,
  password VARCHAR (255) NOT NULL,
  active BOOLEAN
);

-- CREATE TABLE roles (
--   id   SERIAL PRIMARY KEY,
--   name varchar(255) NOT NULL
-- );

-- CREATE TABLE users_roles (
--   user_id INTEGER REFERENCES users(id),
--   role_id INTEGER REFERENCES roles(id)
-- );

-- CREATE TABLE categories (
--   id     SERIAL PRIMARY KEY,
--   name   varchar(255) NOT NULL,
--   active boolean NOT NULL DEFAULT TRUE
-- );

-- CREATE TABLE materials (
--   id     SERIAL PRIMARY KEY,
--   name   varchar(255) NOT NULL,
--   active boolean NOT NULL DEFAULT TRUE
-- );

-- CREATE TABLE audits (
--   id            SERIAL PRIMARY KEY,
--   content       text NOT NULL,
--   modified_by   varchar(255),
--   modified_date timestamp,
--   action        varchar(255) NOT NULL
-- );

CREATE TABLE audits (
  id serial PRIMARY KEY,
  content TEXT,
  modified_by VARCHAR (255),
  modified_date TIMESTAMP,
  action VARCHAR (255) NOT NULL
);

-- CREATE TABLE options (
--   id    SERIAL PRIMARY KEY,
--   name  varchar(255),
--   value varchar(255)
-- );

-- DROP TABLE IF EXISTS `projeto_integrador`.`audits`;
-- DROP TABLE IF EXISTS `projeto_integrador`.`options`;

-- DROP TABLE IF EXISTS `projeto_integrador`.`categories`;
-- DROP TABLE IF EXISTS `projeto_integrador`.`materials`;

-- DROP TABLE IF EXISTS `projeto_integrador`.`users_roles`;
-- DROP TABLE IF EXISTS `projeto_integrador`.`users`;
-- DROP TABLE IF EXISTS `projeto_integrador`.`roles`;

-- CREATE TABLE `projeto_integrador`.`users` (
--   `id` INT PRIMARY KEY AUTO_INCREMENT,
--   `name` VARCHAR(255) NOT NULL,
--   `email` VARCHAR(255) NOT NULL,
--   `username` VARCHAR(255) NOT NULL,
--   `password` VARCHAR(255) NOT NULL,
--   `active` BOOLEAN DEFAULT 1
-- );

-- CREATE TABLE `projeto_integrador`.`roles` (
--   `id` INT PRIMARY KEY AUTO_INCREMENT,
--   `name` VARCHAR(255) NOT NULL
-- );

-- CREATE TABLE `projeto_integrador`.`users_roles` (
--   `user_id` INT NOT NULL,
--   `role_id` INT NOT NULL,
--   FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE CASCADE,
--   FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE RESTRICT ON UPDATE CASCADE
-- );

-- CREATE TABLE `projeto_integrador`.`categories` (
--   `id` INT PRIMARY KEY AUTO_INCREMENT,
--   `name` VARCHAR(255) NULL,
--   `active` BOOLEAN DEFAULT 1
-- );

-- CREATE TABLE `projeto_integrador`.`materials` (
--   `id` INT PRIMARY KEY AUTO_INCREMENT,
--   `name` VARCHAR(255) NOT NULL,
--   `active` BOOLEAN DEFAULT 1
-- );

-- CREATE TABLE `projeto_integrador`.`audits` (
--   `id` INT PRIMARY KEY AUTO_INCREMENT,
--   `content` TEXT NOT NULL,
--   `modified_by` VARCHAR(255) NULL,
--   `modified_date` DATETIME,
--   `action` VARCHAR(255) NOT NULL
-- );

-- CREATE TABLE `projeto_integrador`.`options` (
--   `id` INT PRIMARY KEY AUTO_INCREMENT,
--   `name` VARCHAR(255) NOT NULL,
--   `value` VARCHAR(255) NULL
-- );
