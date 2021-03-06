class SolarRadiation < ApplicationRecord
  audited

  has_many :projects

  validates :name, presence: true
  validates_numericality_of :north_index     , greater_than: 0
  validates_numericality_of :north_east_index, greater_than: 0
  validates_numericality_of :north_west_index, greater_than: 0
  validates_numericality_of :south_index     , greater_than: 0
  validates_numericality_of :south_east_index, greater_than: 0
  validates_numericality_of :south_west_index, greater_than: 0
  validates_numericality_of :east_index      , greater_than: 0
  validates_numericality_of :west_index      , greater_than: 0

  default_scope -> { order :name }
end
