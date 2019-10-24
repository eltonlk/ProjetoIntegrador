class Component < ApplicationRecord
  audited

  belongs_to :face
  belongs_to :color

  has_many :component_materials, dependent: :destroy

  validates :name, presence: true
  validates_numericality_of :area, greater_than: 0
end
