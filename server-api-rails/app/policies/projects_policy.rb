class ProjectsPolicy < ApplicationPolicy
  def send_mail?
    # TODO create role and check if user has permission
    true
  end
end
