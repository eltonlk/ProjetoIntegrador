class Option < ApplicationRecord

  validates_presence_of :name, :value

  validates :value, inclusion: { in: %w(enabled disabled)  }

end
