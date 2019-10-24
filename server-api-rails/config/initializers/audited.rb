module Audited
  class Audit < ::ActiveRecord::Base
    before_create :set_username

    def set_username
      if user.present? and user.respond_to? :name
        self.username = user.name
      end
    end
  end
end
