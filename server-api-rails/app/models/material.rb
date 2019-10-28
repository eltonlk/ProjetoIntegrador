class Material < ApplicationRecord
  audited

  enum kind: %w( opaque translucent air )

  has_many :component_materials

  before_validation :clear_fields_by_kind

  validates :name, presence: true
  validates_numericality_of :thermal_conductivity_index, greater_than: 0, unless: :air?
  validates_numericality_of :solar_factor              , greater_than: 0, if: :translucent?
  validates_numericality_of :resistance                , greater_than: 0, if: :air?

  default_scope -> { order :name }

  private
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
end
