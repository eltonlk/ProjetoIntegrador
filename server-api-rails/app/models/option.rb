class Option < ApplicationRecord
  audited

  validates :name , presence: true
  validates :value, presence: true
end
