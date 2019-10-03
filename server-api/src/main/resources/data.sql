INSERT INTO privileges (id, name) VALUES (1, 'READ_PRIVILEGE');
INSERT INTO privileges (id, name) VALUES (2, 'CREATE_PRIVILEGE');
INSERT INTO privileges (id, name) VALUES (3, 'UPDATE_PRIVILEGE');
INSERT INTO privileges (id, name) VALUES (4, 'DELETE_PRIVILEGE');
INSERT INTO privileges (id, name) VALUES (5, 'UPDATE_PERMISSIONS_PRIVILEGE');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_AUDITS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (1, 1);

INSERT INTO roles (id, name) VALUES (2, 'ROLE_OPTIONS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (2, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (2, 3);

INSERT INTO roles (id, name) VALUES (3, 'ROLE_USERS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 4);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (3, 5);

INSERT INTO roles (id, name) VALUES (4, 'ROLE_COLORS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (4, 4);

INSERT INTO roles (id, name) VALUES (5, 'ROLE_MATERIALS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (5, 4);

INSERT INTO roles (id, name) VALUES (6, 'ROLE_PROJECTS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (6, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (6, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (6, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (6, 4);

INSERT INTO roles (id, name) VALUES (7, 'ROLE_SOLAR_RADIATIONS');
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (7, 1);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (7, 2);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (7, 3);
INSERT INTO roles_privileges (role_id, privilege_id) VALUES (7, 4);

INSERT INTO users (name, email, username, password, active)
VALUES ('Administrador', 'administrador@mail.com', 'admin', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', TRUE),
  ('Colaborador', 'colaborador@mail.com', 'colaborador', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', TRUE),
  ('Estágiario', 'estagiario@mail.com', 'estagiario', '$2a$10$2EJCEa0kr9QFyhm3kguxg.F9jS3rjRRy8Qj0l0.ILBIank0TJoK8G', FALSE);

UPDATE user_roles SET enable = TRUE WHERE user_id IN (SELECT users.id FROM users WHERE username = 'admin');

INSERT INTO options (id, name, value) VALUES (1, 'audits', 'enabled');

INSERT INTO colors (name, absorbability_index, active)
VALUES ('Branco', 0.1, TRUE),
  ('Branco (óxido de zinco)', 0.3, TRUE),
  ('Cinza', 0.75, TRUE),
  ('Preta', 0.9, TRUE),
  ('Aluminío', 0.55, TRUE),
  ('Verde Rosado', 0.65, FALSE);

INSERT INTO materials (name, thermal_conductivity_index, active)
VALUES ('Argamassa comum', 1.15, TRUE),
  ('Reboco', 0.87, TRUE),
  ('Concreto', 1.75, TRUE),
  ('PVC', 0.2, TRUE),
  ('Vidro', 1, TRUE),
  ('Espaço vazio (AR)', 0.17, FALSE);

INSERT INTO solar_radiations (name, index)
VALUES ('Sul', 600),
  ('Sudeste', 700),
  ('Centro-Oeste', 600),
  ('Nordeste', 800),
  ('Norte', 500);

INSERT INTO "audits"("modified_by", "modified_date", "action", "content")
VALUES ('admin', '2019-08-23 00:18:22', 'CREATED', 'Option{id=null, name=''audits'', value=''enabled''}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Color{id=null, name=''Branco'', absorbability_index=0.1, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Color{id=null, name=''Branco (óxido de zinco)'', absorbability_index=0.3, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Color{id=null, name=''Cinza'', absorbability_index=0.75, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Color{id=null, name=''Preta'', absorbability_index=0.9, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Color{id=null, name=''Aluminío'', absorbability_index=0.55, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Color{id=null, name=''Verde Rosado'', absorbability_index=0.65, active=false}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Argamassa comum'', thermal_conductivity_index=1.15, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Reboco'', thermal_conductivity_index=0.87, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Concreto'', thermal_conductivity_index=1.75, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''PVC'', thermal_conductivity_index=0.2, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Vidro'', thermal_conductivity_index=1, active=true}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'Material{id=null, name=''Espaço vazio (AR)'', thermal_conductivity_index=0.17, active=false}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'SolarRadiation{id=null, name=''Sul'', index=600}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'SolarRadiation{id=null, name=''Sudeste'', index=700}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'SolarRadiation{id=null, name=''Centro-Oeste'', index=600}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'SolarRadiation{id=null, name=''Nordeste'', index=800}'),
  ('admin', '2019-08-23 00:18:22', 'CREATED', 'SolarRadiation{id=null, name=''Norte'', index=500}');
