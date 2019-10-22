class Component < ApplicationRecord
  auditedter

  belongs_to :face
  belongs_to :color

  has_many :component_materials

  validates :name, presence: true
  validates_numericality_of :area, greater_than: 0
end
