class Room < ApplicationRecord

  belongs_to :project

  has_many :faces

  validates_presence_of :name

end
