class Component < ApplicationRecord
  audited

  belongs_to :face
  belongs_to :color

  has_many :component_materials

  validates_presence_of :name
  validates_numericality_of :area, greater_than: 0
end
