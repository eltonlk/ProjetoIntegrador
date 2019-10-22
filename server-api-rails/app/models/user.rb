class User < ApplicationRecord
  audited

  has_secure_password

  has_many :roles, class_name: 'UserRole', dependent: :destroy

  validates :email   , presence: true, uniqueness: true
  validates :name    , presence: true
  validates :password, presence: true
  validates :username, presence: true

  trigger.after(:insert) do
    "INSERT INTO user_roles(user_id, role_id, privilege_id) SELECT NEW.id, role_id, privilege_id FROM roles_privileges;"
  end
end
