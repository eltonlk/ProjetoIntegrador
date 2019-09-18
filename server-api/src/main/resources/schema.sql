DROP TABLE IF EXISTS audits;
DROP TABLE IF EXISTS options;

DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS materials;

DROP TABLE IF EXISTS roles_privileges CASCADE;
DROP TABLE IF EXISTS users_roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS privileges CASCADE;
DROP TABLE IF EXISTS roles CASCADE;

CREATE TABLE users (
  id       SERIAL PRIMARY KEY,
  name     VARCHAR (255) UNIQUE NOT NULL,
  email    VARCHAR (255) UNIQUE NOT NULL,
  username VARCHAR (255) UNIQUE NOT NULL,
  password VARCHAR (255) NOT NULL,
  active   BOOLEAN
);

CREATE TABLE roles (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE users_roles (
  user_id INTEGER REFERENCES users(id),
  role_id INTEGER REFERENCES roles(id)
);

CREATE TABLE privileges (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE roles_privileges (
  role_id      INTEGER REFERENCES roles(id),
  privilege_id INTEGER REFERENCES privileges(id)
);

CREATE TABLE categories (
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(255) NOT NULL,
  active BOOLEAN
);

CREATE TABLE materials (
  id     SERIAL PRIMARY KEY,
  name   VARCHAR(255) NOT NULL,
  active BOOLEAN,
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
