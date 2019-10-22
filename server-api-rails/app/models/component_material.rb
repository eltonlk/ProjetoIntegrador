class ComponentMaterial < ApplicationRecord

  belongs_to :component
  belongs_to :material

  validates_presence_of :name
  validates_numericality_of :width, greater_than: 0
  validates_numericality_of :thermal_conductivity_index, greater_than: 0

end
