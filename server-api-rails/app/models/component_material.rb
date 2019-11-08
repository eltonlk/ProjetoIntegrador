class ComponentMaterial < ApplicationRecord
  audited

  enum kind: %w( opaque translucent air )

  belongs_to :component
  belongs_to :material

  before_validation :set_kind
  before_validation :clear_fields_by_kind

  validates_numericality_of :width, greater_than: 0
  validates_numericality_of :thermal_conductivity_index, greater_than: 0, unless: :air?
  validates_numericality_of :solar_factor              , greater_than: 0, if: :translucent?
  validates_numericality_of :resistance                , greater_than: 0, if: :air?

  before_save :set_resistance
  after_save :save_component
  after_destroy :save_component

  default_scope -> { order id: :desc }

  private
    def set_kind
      self.kind = material.kind
    end

    def clear_fields_by_kind
      if opaque?
        self.solar_factor = 0
        self.resistance = 0
      elsif translucent?
        self.resistance = 0
      elsif air?
        self.thermal_conductivity_index = 0
        self.solar_factor = 0
      end
    end

    def set_resistance
      if opaque? or translucent?
        self.resistance = width / thermal_conductivity_index
      end
    end

    def save_component
      self.component.save
    end
end
