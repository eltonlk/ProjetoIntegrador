class RolesController < ApplicationController

  def index
    @roles = Role.all

    render json: @roles, status: :ok
  end

end
