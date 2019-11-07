class ReportsPolicy < ApplicationPolicy
    def index?
      # TODO create role and check if user has permission
      true
    end
  end
