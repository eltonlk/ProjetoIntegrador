-- BEGIN CREATE users
DROP TABLE IF EXISTS `projeto_integrador`.`users`;

CREATE TABLE `projeto_integrador`.`users` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `active` BOOLEAN DEFAULT TRUE
);
-- END CREATE users

-- BEGIN CREATE roles
DROP TABLE IF EXISTS `projeto_integrador`.`roles`;

CREATE TABLE `projeto_integrador`.`roles` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL
);
-- END CREATE roles

-- BEGIN CREATE privileges
DROP TABLE IF EXISTS `projeto_integrador`.`privileges`;

CREATE TABLE `projeto_integrador`.`privileges` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL
);
-- END CREATE privileges

-- BEGIN CREATE users_roles
DROP TABLE IF EXISTS `projeto_integrador`.`users_roles`;

CREATE TABLE `projeto_integrador`.`users_roles` (
  `user_id` INT
  `role_id` INT
);
-- END CREATE users_roles


-- CREATE TABLE company_employee (
--     employee_id INTEGER NOT NULL,
--     company_id INTEGER NOT NULL,
--     work_hour_start TIME NOT NULL,
--     work_hour_end TIME NOT NULL,
--     FOREIGN KEY (employee_id) REFERENCES employee (employee_id) ON DELETE RESTRICT ON UPDATE CASCADE,
--     FOREIGN KEY (company_id) REFERENCES company (company_id) ON DELETE RESTRICT ON UPDATE CASCADE,
--     PRIMARY KEY (employee_id, company_id, work_hour_start, work_hour_end)
-- );

-- BEGIN CREATE roles_privileges
DROP TABLE IF EXISTS `projeto_integrador`.`roles_privileges`;

CREATE TABLE `projeto_integrador`.`roles_privileges` (
  `role_id` INT
  `privilege_id` INT
);
-- END CREATE roles_privileges

-- BEGIN CREATE categories
DROP TABLE IF EXISTS `projeto_integrador`.`categories`;

CREATE TABLE `projeto_integrador`.`categories` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NULL
);
-- END CREATE categories

-- BEGIN CREATE materials
DROP TABLE IF EXISTS `projeto_integrador`.`materials`;

CREATE TABLE `projeto_integrador`.`materials` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL
);
-- END CREATE categories
