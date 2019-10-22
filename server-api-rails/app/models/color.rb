class Color < ApplicationRecord

  has_many :components, dependent: :nullify

  validates_presence_of :name
  validates_numericality_of :absorbability_index, greater_than: 0

end
