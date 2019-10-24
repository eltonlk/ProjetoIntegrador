class Room < ApplicationRecord
  audited

  belongs_to :project

  has_many :faces, dependent: :destroy

  validates :name, presence: true
end
