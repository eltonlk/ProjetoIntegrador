Color.create! name: "Branco"                 , absorbability_index: 0.1
Color.create! name: "Branco (óxido de zinco)", absorbability_index: 0.3
Color.create! name: "Cinza"                  , absorbability_index: 0.75
Color.create! name: "Preto"                  , absorbability_index: 0.9
Color.create! name: "Aluminío"               , absorbability_index: 0.55
Color.create! name: "Verde Rosado"           , absorbability_index: 0.65, active: false

Material.create! name: "Argamassa comum"  , thermal_conductivity_index: 1.15
Material.create! name: "Reboco"           , thermal_conductivity_index: 0.87
Material.create! name: "Concreto"         , thermal_conductivity_index: 1.75
Material.create! name: "PVC"              , thermal_conductivity_index: 0.2
Material.create! name: "Vidro"            , thermal_conductivity_index: 1
Material.create! name: "Espaço vazio (AR)", thermal_conductivity_index: 0.17, active: false

SolarRadiation.create! name: "Sul", north_index: 179, north_east_index: 475, east_index: 715, south_east_index: 586,
  south_index: 188, south_west_index: 586, west_index: 715, north_west_index: 475
SolarRadiation.create! name: "Sudeste", north_index: 700, north_east_index: 700, east_index: 700, south_east_index: 700,
  south_index: 700, south_west_index: 700, west_index: 700, north_west_index: 700
SolarRadiation.create! name: "Sudeste", north_index: 600, north_east_index: 600, east_index: 600, south_east_index: 600,
  south_index: 600, south_west_index: 600, west_index: 600, north_west_index: 600
SolarRadiation.create! name: "Sudeste", north_index: 800, north_east_index: 800, east_index: 800, south_east_index: 800,
  south_index: 800, south_west_index: 800, west_index: 800, north_west_index: 800
SolarRadiation.create! name: "Sudeste", north_index: 500, north_east_index: 500, east_index: 500, south_east_index: 500,
  south_index: 500, south_west_index: 500, west_index: 500, north_west_index: 500

read_privilege   = Privilege.create! name: 'READ_PRIVILEGE'
create_privilege = Privilege.create! name: 'CREATE_PRIVILEGE'
update_privilege = Privilege.create! name: 'UPDATE_PRIVILEGE'
delete_privilege = Privilege.create! name: 'DELETE_PRIVILEGE'

Role.create! name: 'ROLE_AUDITS'          , privileges: [ read_privilege ]
Role.create! name: 'ROLE_OPTIONS'         , privileges: [ read_privilege, update_privilege ]
Role.create! name: 'ROLE_USERS'           , privileges: [ read_privilege, create_privilege, update_privilege, delete_privilege ]
Role.create! name: 'ROLE_USER_ROLES'      , privileges: [ read_privilege, update_privilege ]
Role.create! name: 'ROLE_COLORS'          , privileges: [ read_privilege, create_privilege, update_privilege, delete_privilege ]
Role.create! name: 'ROLE_MATERIALS'       , privileges: [ read_privilege, create_privilege, update_privilege, delete_privilege ]
Role.create! name: 'ROLE_PROJECTS'        , privileges: [ read_privilege, create_privilege, update_privilege, delete_privilege ]
Role.create! name: 'ROLE_SOLAR_RADIATIONS', privileges: [ read_privilege, create_privilege, update_privilege, delete_privilege ]

User.create! name: 'Administrador', email: 'administrador@mail.com', username: 'admin'      , password: '123456789', active: true
User.create! name: 'Colaborador'  , email: 'colaborador@mail.com'  , username: 'colaborador', password: '123456789', active: true
User.create! name: 'Estágiario'   , email: 'estagiario@mail.com'   , username: 'estagiario' , password: '123456789', active: false

Option.create! name: 'audits', value: 'enabled'

User.find_by(username: 'admin').roles.each do |role|
  role.update_attribute :enable, true
end
