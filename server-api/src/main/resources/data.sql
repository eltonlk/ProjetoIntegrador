INSERT INTO privileges (id, name) VALUES (1, 'READ_PRIVILEGE');
INSERT INTO privileges (id, name) VALUES (2, 'CREATE_PRIVILEGE');
INSERT INTO privileges (id, name) VALUES (3, 'UPDATE_PRIVILEGE');
INSERT INTO privileges (id, name) VALUES (4, 'DELETE_PRIVILEGE');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_AUDITS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 3);

INSERT INTO roles (id, name) VALUES (2, 'ROLE_OPTIONS');

INSERT INTO roles (id, name) VALUES (3, 'ROLE_USERS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 4);

INSERT INTO roles (id, name) VALUES (4, 'ROLE_CATEGORIES');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 4);

INSERT INTO roles (id, name) VALUES (5, 'ROLE_MATERIALS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 4);

INSERT INTO users (id, name, email, username, password, active)
VALUES (1, 'Administrador', 'administrador@mail.com', 'admin', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', TRUE),
  (2, 'Colaborador', 'colaborador@mail.com', 'colaborador', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', TRUE),
  (3, 'Estágiario', 'estagiario@mail.com', 'estagiario', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', FALSE);

UPDATE user_roles SET enable = TRUE WHERE user_id = 1;

INSERT INTO options (id, name, value) VALUES (1, 'audits', 'enabled');

INSERT INTO categories (name, active)
VALUES ('Muito leve', TRUE),
  ('Leve', TRUE),
  ('Mediano', TRUE),
  ('Pesado', TRUE),
  ('Muito pesado', TRUE),
  ('Extremamente leve', FALSE);

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
