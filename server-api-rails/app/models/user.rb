class User < ApplicationRecord

  has_many :roles, class_name: "UserRole"

  validates_presence_of :name, :email, :username, :password

end
