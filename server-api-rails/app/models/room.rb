class Room < ApplicationRecord
  audited

  belongs_to :project

  has_many :faces

  validates :name, presence: true
end
