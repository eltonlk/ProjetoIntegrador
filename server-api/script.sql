CREATE TABLE `projeto_integrador`.`users` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NULL,
  `login` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `projeto_integrador`.`users`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);

CREATE TABLE `projeto_integrador`.`categories` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NULL
  PRIMARY KEY (`id`)
);

ALTER TABLE `projeto_integrador`.`categories`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);

CREATE TABLE `projeto_integrador`.`materials` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NULL
  PRIMARY KEY (`id`)
);

ALTER TABLE `projeto_integrador`.`materials`
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT,
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);
