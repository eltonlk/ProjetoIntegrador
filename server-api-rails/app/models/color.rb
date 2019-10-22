class Color < ApplicationRecord
  audited

  has_many :components, dependent: :nullify

  validates :name, presence: true
  validates_numericality_of :absorbability_index, greater_than: 0
end
