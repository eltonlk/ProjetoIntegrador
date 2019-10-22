class ApplicationPolicy
  attr_reader :user, :record, :role

  def initialize user, record
    @user = user
    @record = record

    @role = Role.find_by name: "ROLE_#{record.to_s.upcase}"
  end

  def index?
    can? "READ_PRIVILEGE"
  end

  def show?
    can? "READ_PRIVILEGE"
  end

  def create?
    can? "CREATE_PRIVILEGE"
  end

  def update?
    can? "UPDATE_PRIVILEGE"
  end

  def destroy?
    can? "DELETE_PRIVILEGE"
  end

  private
    def can? privilege_name
      privilege = Privilege.find_by name: privilege_name

      user_role = user.roles.find_by role_id: @role, privilege_id: privilege

      user_role.present? and user_role.enable?
    end

  class Scope
    attr_reader :user, :scope

    def initialize user, scope
      @user = user
      @scope = scope
    end

    def resolve
      scope.all
    end
  end
end
