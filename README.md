# ProjetoIntegrador

### Usuários

username: admin
password: 123456789
roles: ADMIN, CATEGORIES, MATERIALS

username: colaborador
password: 123456789
roles: CATEGORIES, MATERIALS

username: estagiario
password: 123456789
roles: CATEGORIES

## Api Rest
Content-type: application/json

http://localhost:8080/login => POST
- username
- password

http://localhost:8080/users => GET, POST, PUT, DELETE
- name
- email
- username
- password
- active

http://localhost:8080/roles => GET

http://localhost:8080/audits => GET

http://localhost:8080/options => GET, PUT
- name
- value

http://localhost:8080/colors => GET, POST, PUT, DELETE
- name
- absorbability_index
- active

http://localhost:8080/materials => GET, POST, PUT, DELETE
- name
- thermal_conductivity_index
- active

http://localhost:8080/solar_radiations => GET, POST, PUT, DELETE
- name
- index

http://localhost:8080/projects => GET, POST, PUT, DELETE
- name
- solar_radiation_id

http://localhost:8080/rooms => GET, POST, PUT, DELETE
- name
- heat_load
- project_id

http://localhost:8080/faces => GET, POST, PUT, DELETE
- name
- heat_flow
- room_id

http://localhost:8080/components => GET, POST, PUT, DELETE
- name
- area
- heat_flow
- face_id
- color_id

http://localhost:8080/component_materials => GET, POST, PUT, DELETE
- name
- width
- thermal_conductivity_index
- resistance
- component_id
- material_id

## Heroku

heroku login
heroku apps
heroku git:remote -a eltonlk-projeto-integrador
git subtree push --prefix web heroku master

https://eltonlk-projeto-integrador.herokuapp.com/
