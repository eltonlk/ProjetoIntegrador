class Component < ApplicationRecord
  audited

  belongs_to :face
  belongs_to :color

  has_many :component_materials, dependent: :destroy

  validates :name, presence: true
  validates_numericality_of :area, greater_than: 0

  before_save :set_heat_flow
  after_save :save_face

  private
    def set_heat_flow
      # TODO: check if this component is a glass, caculate ( u * ( te - ti ) + fs * i )

      project = face.room.project

      self.heat_flow = if project.summer?
        summer_heat_flow_calculate
      elsif project.winter?
        witer_heat_flow_calculate
      end
    end

    def save_face
      self.face.save
    end

    def summer_heat_flow_calculate
      thermalTransmittance = area / resistance

      u = thermalTransmittance
      a = color.absorbability_index
      i = face.room.project.solar_radiation.send "#{face.orientation}_index"
      rse = 0.04
      te = face.room.project.external_temperature
      ti = face.room.project.internal_temperature

      u * ( a * i * rse + te - ti )
    end

    def witer_heat_flow_calculate
      thermalTransmittance = area / resistance

      u = thermalTransmittance
      te = face.room.project.external_temperature
      ti = face.room.project.internal_temperature

      u * ( te - ti )
    end

    def resistance
      resistance = 0
      resistance += 0.04 # External Surface Resistance
      resistance += component_materials.sum(:resistance)
      resistance += if face.slab? and face.room.project.winter?
        0.1 # Internal Surface Resistance for slab in winter;
      elsif face.slab? and face.room.project.summer?
        0.17 # Internal Surface Resistance for slab in summer;
      else
        0.13 # Internal Surface Resistance for wall;
      end
      resistance
    end
end
