class Face < ApplicationRecord
  audited

  belongs_to :room

  has_many :components

  validates :name       , presence: true
  validates :orientation, presence: true

  validates :orientation, inclusion: { in: %w(north north_east north_west south south_east south_west east west)  }
end
