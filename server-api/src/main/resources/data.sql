INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_CATEGORIES');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_MATERIALS');

INSERT INTO users (id, name, email, username, password, active)
VALUES (1, 'Administrador', 'administrador@mail.com', 'admin', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', TRUE);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (1, 3);

INSERT INTO users (id, name, email, username, password, active)
VALUES (2, 'Colaborador', 'colaborador@mail.com', 'colaborador', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', TRUE);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 3);

INSERT INTO users (id, name, email, username, password, active)
VALUES (3, 'Estágiario', 'estagiario@mail.com', 'estagiario', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', FALSE);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);

INSERT INTO options (id, name, value) VALUES (1, 'audits', 'enabled');

INSERT INTO categories (name, active) VALUES ('Muito leve', TRUE);
INSERT INTO categories (name, active) VALUES ('Leve', TRUE);
INSERT INTO categories (name, active) VALUES ('Mediano', TRUE);
INSERT INTO categories (name, active) VALUES ('Pesado', TRUE);
INSERT INTO categories (name, active) VALUES ('Muito pesado', TRUE);
INSERT INTO categories (name, active) VALUES ('Extremamente leve', FALSE);

INSERT INTO materials (name, active, thermal_conductivity_index)
VALUES ('Alvenaria', TRUE, 123.231),
  ('Gesso', TRUE, 12345.12345),
  ('Madeira', TRUE, 12.23),
  ('PVC', TRUE, 10),
  ('Vidro', TRUE, 0.123),
  ('Espaço vazio', FALSE, 12345);

INSERT INTO "audits"("modified_by", "modified_date", "action", "content")
VALUES ('admin', '2019-08-23 00:18:22', 'CREATED', 'Option{id=null, name=''audits'', value=''enabled''}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Category{id=null, name=''Muito leve'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Category{id=null, name=''Leve'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Category{id=null, name=''Mediano'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Category{id=null, name=''Pesado'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Category{id=null, name=''Muito pesado'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Category{id=null, name=''Extremamente leve'', active=false}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Alvenaria'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Gesso'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Madeira'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''PVC'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Vidro'', active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Espaço vazio'', active=true}');
