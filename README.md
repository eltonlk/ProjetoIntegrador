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

http://localhost:8080/categories => GET, POST, PUT, DELETE
- name
- active

http://localhost:8080/materials => GET, POST, PUT, DELETE
- name
- active

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

## Heroku

heroku login
heroku apps
heroku git:remote -a eltonlk-projeto-integrador
git subtree push --prefix web heroku master

https://eltonlk-projeto-integrador.herokuapp.com/
