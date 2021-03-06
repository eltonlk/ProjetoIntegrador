Rails.application.routes.draw do
  root to: 'welcome#index'

  resource :welcome, only: [ :index ]

  resource :login, only: [ :create ], controller: 'session'

  resource :user, only: [ :show ], controller: 'user'

  resources :users, only: [ :index, :show, :create, :update, :destroy ]
  resources :user_roles, only: [ :index, :show, :update ]

  resources :audits, only: [ :index ]

  resources :options, only: [ :index, :show, :update ]

  resources :projects, only: [ :index, :show, :create, :update, :destroy ] do
    post :send_mail, on: :member
  end

  resources :rooms, only: [ :create, :update, :destroy ]

  resources :faces, only: [ :create, :update, :destroy ]

  resources :components, only: [ :create, :update, :destroy ]

  resources :component_materials, only: [ :create, :update, :destroy ]

  resources :materials, only: [ :index, :create, :update, :destroy ] do
    post :import, on: :collection
  end

  resources :colors, only: [ :index, :create, :update, :destroy ] do
    post :import, on: :collection
  end

  resources :solar_radiations, only: [ :index, :create, :update, :destroy ] do
    post :import, on: :collection
  end

  resources :reports, only: [ :index ]
end
