class Face < ApplicationRecord
  audited

  enum kind: %w( wall slab )

  belongs_to :room

  has_many :components, dependent: :destroy

  validates :kind       , presence: true
  validates :orientation, presence: true

  validates :kind, inclusion: { in: %w( wall slab )  }
  validates :orientation, inclusion: { in: %w( north north_east north_west south south_east south_west east west perpendicular )  }

  before_save :set_heat_flow
  after_update :save_components
  after_save :save_room

  private
    def set_heat_flow
      self.heat_flow = components.sum(:heat_flow)
    end

    def save_components
      if orientation_previously_changed?
        components.each(&:save)
      end
    end

    def save_room
      self.room.save
    end
end
