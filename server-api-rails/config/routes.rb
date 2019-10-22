Rails.application.routes.draw do

  post :login, action: :create, controller: :login

  resources :projects, only: [ :index, :show, :create, :update, :destroy ]
  resources :rooms, only: [ :create, :update, :destroy ]
  resources :faces, only: [ :create, :update, :destroy ]
  resources :components, only: [ :create, :update, :destroy ]
  resources :component_materials, only: [ :create, :update, :destroy ]

  resources :materials, only: [ :index, :create, :update, :destroy ]
  resources :colors, only: [ :index, :create, :update, :destroy ]
  resources :solar_radiations, only: [ :index, :create, :update, :destroy ]

  resources :users, only: [ :index, :show, :create, :update, :destroy ]
  resources :roles, only: [ :index ]

  resources :audits, only: [ :index ]
  resources :options, only: [ :index, :update ]

end
