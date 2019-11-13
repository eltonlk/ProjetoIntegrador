class UserRolesPolicy < ApplicationPolicy

  private
    def role_name
      "ROLE_USERS"
    end

end
