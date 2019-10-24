class Project < ApplicationRecord
  audited

  enum season: [ :summer, :winter ]

  belongs_to :solar_radiation

  has_many :rooms, dependent: :destroy

  validates :name  , presence: true
  validates :season, presence: true
  validates_numericality_of :external_temperature
  validates_numericality_of :internal_temperature
  validates :season, inclusion: { in: %w(summer winter)  }

  after_update :save_components

  private
    def save_components
      if season_previously_changed? or external_temperature_previously_changed? or
        internal_temperature_previously_changed? or solar_radiation_id_previously_changed?

        Component.includes(face: :room).where(rooms: { project_id: id }).each(&:save)
      end
    end
end
