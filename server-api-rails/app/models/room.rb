class Room < ApplicationRecord
  audited

  belongs_to :project

  has_many :faces, dependent: :destroy

  validates :name, presence: true

  before_save :set_heat_load

  default_scope -> { order id: :desc }

  private
    def set_heat_load
      self.heat_load = faces.sum(:heat_flow)
    end
end
