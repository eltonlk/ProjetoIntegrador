class Material < ApplicationRecord
  audited

  has_many :component_materials

  validates :name, presence: true
  validates_numericality_of :thermal_conductivity_index, greater_than: 0
end
