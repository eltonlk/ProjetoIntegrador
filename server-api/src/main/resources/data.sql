INSERT INTO roles (id, name) VALUES (1, 'categories');
INSERT INTO roles (id, name) VALUES (2, 'materials');

INSERT INTO users (id, name, email, username, password, admin, active) VALUES (1, 'Administrador', 'administrador@mail.com', 'admin', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', 1, 1);
INSERT INTO users (id, name, email, username, password, admin, active) VALUES (2, 'Colaborador', 'colaborador@mail.com', 'colaborador', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', 0, 1);

INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);

INSERT INTO categories (name) VALUES ('Muito leve');
INSERT INTO categories (name) VALUES ('Leve');
INSERT INTO categories (name) VALUES ('Mediano');
INSERT INTO categories (name) VALUES ('Pesado');
INSERT INTO categories (name) VALUES ('Muito pesado');

INSERT INTO materials (name) VALUES ('Alvenaria');
INSERT INTO materials (name) VALUES ('Gesso');
INSERT INTO materials (name) VALUES ('Madeira');
INSERT INTO materials (name) VALUES ('PVC');
INSERT INTO materials (name) VALUES ('Vidro');
