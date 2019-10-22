class Face < ApplicationRecord

  belongs_to :room

  has_many :components

  validates_presence_of :name
  validates_presence_of :orientation

  validates :orientation, inclusion: { in: %w(north north_east north_west south south_east south_west east west)  }

end
