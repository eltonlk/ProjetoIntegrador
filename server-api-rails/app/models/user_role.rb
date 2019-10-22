class UserRole < ApplicationRecord
  audited

  belongs_to :user
  belongs_to :role
  belongs_to :privilege
end
