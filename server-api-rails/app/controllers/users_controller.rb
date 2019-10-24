class UsersController < ApplicationController
  before_action do
    authorize :users
  end

  before_action :set_user, only: [ :show, :update, :destroy ]

  # GET /users
  def index
    @users = User.all

    render json: @users
  end

  # GET /users/1
  def show
    render json: @user
  end

  # POST /users
  def create
    @user = User.new create_user_params

    if @user.save
      render json: @user, status: :created, location: @user
    else
      render json: @user.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /users/1
  def update
    if @user.update update_user_params
      render json: @user
    else
      debugger

      render json: @user.errors, status: :unprocessable_entity
    end
  end

  # DELETE /users/1
  def destroy
    @user.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_user
      @user = User.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def create_user_params
      params.permit(:name, :email, :username, :password, :active)
    end

    def update_user_params
      params.permit(:name, :email, :username, :active)
    end
end
