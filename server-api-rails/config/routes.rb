Rails.application.routes.draw do
  resource :login, only: [ :create ], controller: 'session'

  resources :users
  resources :user_roles, only: [ :index, :show, :update ]

  resources :audits, only: [ :index ]

  resources :options, only: [ :index, :show, :update ]

  resources :projects
  resources :rooms
  resources :faces
  resources :components
  resources :component_materials

  resources :materials
  resources :colors
  resources :solar_radiations
end
