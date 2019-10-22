class Face < ApplicationRecord
  audited

  belongs_to :room

  has_many :components

  validates_presence_of :name
  validates_presence_of :orientation
end
