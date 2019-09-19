DROP TABLE IF EXISTS roles_privileges CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS privileges CASCADE;
DROP TABLE IF EXISTS roles CASCADE;

DROP TABLE IF EXISTS audits CASCADE;
DROP TABLE IF EXISTS options CASCADE;

DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS materials CASCADE;

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

CREATE TABLE categories (
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(255) NOT NULL,
  active BOOLEAN DEFAULT TRUE
);

CREATE TABLE materials (
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(255) NOT NULL,
  active BOOLEAN DEFAULT TRUE,
  thermal_conductivity_index NUMERIC(10, 5) NOT NULL DEFAULT 0
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
