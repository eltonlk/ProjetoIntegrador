DROP TABLE IF EXISTS roles_privileges CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS privileges CASCADE;
DROP TABLE IF EXISTS roles CASCADE;

DROP TABLE IF EXISTS audits CASCADE;
DROP TABLE IF EXISTS options CASCADE;

DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS colors CASCADE;
DROP TABLE IF EXISTS materials CASCADE;
DROP TABLE IF EXISTS solar_radiations CASCADE;
DROP TABLE IF EXISTS projects CASCADE;
DROP TABLE IF EXISTS rooms CASCADE;
DROP TABLE IF EXISTS faces CASCADE;
DROP TABLE IF EXISTS components CASCADE;
DROP TABLE IF EXISTS component_materials CASCADE;

CREATE TABLE roles (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE privileges (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE roles_privileges (
  role_id      INTEGER REFERENCES roles(id),
  privilege_id INTEGER REFERENCES privileges(id)
);

CREATE TABLE users (
  id       SERIAL PRIMARY KEY,
  name     VARCHAR (255) UNIQUE NOT NULL,
  email    VARCHAR (255) UNIQUE NOT NULL,
  username VARCHAR (255) UNIQUE NOT NULL,
  password VARCHAR (255) NOT NULL,
  active   BOOLEAN DEFAULT TRUE
);

CREATE TABLE user_roles (
  id           SERIAL PRIMARY KEY,
  user_id      INTEGER REFERENCES users(id),
  role_id      INTEGER REFERENCES roles(id),
  privilege_id INTEGER REFERENCES privileges(id),
  enable       BOOLEAN DEFAULT FALSE
);

CREATE TABLE colors (
  id                  SERIAL PRIMARY KEY,
  name                VARCHAR(255) NOT NULL,
  absorbability_index NUMERIC(10, 5) NOT NULL DEFAULT 0,
  active              BOOLEAN DEFAULT TRUE
);

CREATE TABLE materials (
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(255) NOT NULL,
  active BOOLEAN DEFAULT TRUE,
  thermal_conductivity_index NUMERIC(10, 5) NOT NULL DEFAULT 0
);

CREATE TABLE solar_radiations (
  id    SERIAL PRIMARY KEY,
  name  VARCHAR(255) NOT NULL,
  index INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE projects (
  id                 SERIAL PRIMARY KEY,
  name               VARCHAR(255) NOT NULL,
  solar_radiation_id INTEGER REFERENCES solar_radiations(id)
);

CREATE TABLE rooms (
  id         SERIAL PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  heat_load  NUMERIC(10, 5) NOT NULL DEFAULT 0,
  project_id INTEGER REFERENCES projects(id)
);

CREATE TABLE faces (
  id        SERIAL PRIMARY KEY,
  name      VARCHAR(255) NOT NULL,
  heat_load NUMERIC(10, 5) NOT NULL DEFAULT 0,
  room_id   INTEGER REFERENCES rooms(id)
);

CREATE TABLE components (
  id                    SERIAL PRIMARY KEY,
  name                  VARCHAR(255) NOT NULL,
  area                  NUMERIC(10, 5) NOT NULL DEFAULT 0,
  thermal_transmittance NUMERIC(10, 5) NOT NULL DEFAULT 0,
  face_id               INTEGER REFERENCES faces(id),
  color_id              INTEGER REFERENCES colors(id)
);

CREATE TABLE component_materials (
  id                         SERIAL PRIMARY KEY,
  width                      NUMERIC(5, 3) NOT NULL DEFAULT 0,
  thermal_conductivity_index NUMERIC(10, 5) NOT NULL DEFAULT 0,
  resistance                 NUMERIC(10, 5) NOT NULL DEFAULT 0,
  component_id               INTEGER REFERENCES components(id),
  material_id                INTEGER REFERENCES materials(id)
);

CREATE TABLE audits (
  id            SERIAL PRIMARY KEY,
  content       TEXT,
  modified_by   VARCHAR (255),
  modified_date TIMESTAMP,
  action        VARCHAR (255) NOT NULL
);

CREATE TABLE options (
  id    SERIAL PRIMARY KEY,
  name  VARCHAR(255),
  value VARCHAR(255)
);

CREATE OR REPLACE FUNCTION after_create_user_insert_user_rules_function()
RETURNS TRIGGER AS '
  BEGIN
    INSERT INTO user_roles(user_id, role_id, privilege_id)
    SELECT NEW.id, role_id, privilege_id FROM roles_privileges;

    RETURN NEW;
  END;
' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS after_create_user_insert_user_rules ON users;

CREATE TRIGGER after_create_user_insert_user_rules
AFTER INSERT
ON users
FOR EACH ROW
EXECUTE PROCEDURE after_create_user_insert_user_rules_function();
