class ComponentMaterial < ApplicationRecord
  audited

  belongs_to :component
  belongs_to :material

  validates_numericality_of :width, greater_than: 0
  validates_numericality_of :thermal_conductivity_index, greater_than: 0

  before_save :set_resistance
  after_save :save_component

  private
    def set_resistance
      self.resistance = width / thermal_conductivity_index
    end

    def save_component
      self.component.save
    end
end
