INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_CATEGORIES');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_MATERIALS');

INSERT INTO users (id, name, email, username, password, active)
VALUES (1, 'Administrador', 'administrador@mail.com', 'admin', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 3);

INSERT INTO users (id, name, email, username, password, active)
VALUES (2, 'Colaborador', 'colaborador@mail.com', 'colaborador', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 3);

INSERT INTO users (id, name, email, username, password, active)
VALUES (3, 'Estágiario', 'estagiario@mail.com', 'estagiario', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', 0);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);

INSERT INTO categories (name, active) VALUES ('Muito leve', 1);
INSERT INTO categories (name, active) VALUES ('Leve', 1);
INSERT INTO categories (name, active) VALUES ('Mediano', 1);
INSERT INTO categories (name, active) VALUES ('Pesado', 1);
INSERT INTO categories (name, active) VALUES ('Muito pesado', 1);
INSERT INTO categories (name, active) VALUES ('Extremamente leve', 0);

INSERT INTO materials (name, active) VALUES ('Alvenaria', 1);
INSERT INTO materials (name, active) VALUES ('Gesso', 1);
INSERT INTO materials (name, active) VALUES ('Madeira', 1);
INSERT INTO materials (name, active) VALUES ('PVC', 1);
INSERT INTO materials (name, active) VALUES ('Vidro', 1);
INSERT INTO materials (name, active) VALUES ('Espaço vazio', 0);
