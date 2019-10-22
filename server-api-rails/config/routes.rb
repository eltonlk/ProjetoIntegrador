Rails.application.routes.draw do

  resource :login, only: [ :create ], controller: 'session'

  resources :users, only: [ :index, :show, :create, :update, :destroy ]
  resources :user_roles, only: [ :index, :show, :update ]

  resources :audits, only: [ :index ]

  resources :options, only: [ :index, :show, :update ]

  resources :projects, only: [ :index, :show, :create, :update, :destroy ]
  resources :rooms, only: [ :create, :update, :destroy ]
  resources :faces, only: [ :create, :update, :destroy ]
  resources :components, only: [ :create, :update, :destroy ]
  resources :component_materials, only: [ :create, :update, :destroy ]

  resources :materials, only: [ :index, :create, :update, :destroy ]
  resources :colors, only: [ :index, :create, :update, :destroy ]
  resources :solar_radiations, only: [ :index, :create, :update, :destroy ]

end
