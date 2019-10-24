class Face < ApplicationRecord
  audited

  belongs_to :room

  has_many :components, dependent: :destroy

  validates :name       , presence: true
  validates :orientation, presence: true

  validates :orientation, inclusion: { in: %w(north north_east north_west south south_east south_west east west)  }

  before_save :set_heat_flow
  after_save :save_room

  private
    def set_heat_flow
      self.heat_flow = components.sum(:heat_flow)
    end

    def save_room
      self.room.save
    end
end
