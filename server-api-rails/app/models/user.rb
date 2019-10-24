class User < ApplicationRecord
  audited

  has_secure_password validations: false

  has_many :roles, class_name: 'UserRole', dependent: :destroy

  validates :email   , presence: true, uniqueness: true
  validates :name    , presence: true
  validates :password, presence: true, on: :create
  validates :username, presence: true

  default_scope -> { order :name }
end
