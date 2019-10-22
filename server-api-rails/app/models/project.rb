class Project < ApplicationRecord

  belongs_to :solar_radiation

  has_many :rooms

  validates_presence_of     :name
  validates_presence_of     :season
  validates_numericality_of :external_temperature
  validates_numericality_of :internal_temperature

  validates :season, inclusion: { in: %w(summer winter)  }

end
