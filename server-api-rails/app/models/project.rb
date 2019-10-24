class Project < ApplicationRecord
  audited

  enum season: [ :summer, :winter ]

  belongs_to :solar_radiation

  has_many :rooms

  validates :name  , presence: true
  validates :season, presence: true
  validates_numericality_of :external_temperature
  validates_numericality_of :internal_temperature
  validates :season, inclusion: { in: %w(summer winter)  }
end
