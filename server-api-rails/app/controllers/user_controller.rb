class UserController < ApplicationController

  # GET /user
  def show
    render json: current_user, include: { roles: { include: [ :role, :privilege ] } }
  end

end
