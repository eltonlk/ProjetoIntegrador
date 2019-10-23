class User < ApplicationRecord
  audited

  has_secure_password

  has_many :roles, class_name: 'UserRole', dependent: :destroy

  validates :email   , presence: true, uniqueness: true
  validates :name    , presence: true
  validates :password, presence: true
  validates :username, presence: true
end
