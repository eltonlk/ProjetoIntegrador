class UserRolesController < ApplicationController
  before_action do
    authorize :user_roles
  end

  before_action :set_user_role, only: [ :show, :update ]

  # GET /user_roles
  def index
    @user_roles = UserRole.all

    render json: @user_roles
  end

  # GET /user_roles/1
  def show
    render json: @user_role
  end

  # PATCH/PUT /user_roles/1
  def update
    if @user_role.update user_role_params
      render json: @user_role
    else
      render json: @user_role.errors, status: :unprocessable_entity
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_user_role
      @user_role = UserRole.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def user_role_params
      params.permit(:enable)
    end
end
