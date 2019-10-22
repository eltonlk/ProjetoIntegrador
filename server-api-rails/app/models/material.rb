class Material < ApplicationRecord

  has_many :component_materials

  validates_presence_of :name
  validates_numericality_of :thermal_conductivity_index, greater_than: 0

end
