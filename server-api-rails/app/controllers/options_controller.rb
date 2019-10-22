class OptionsController < ApplicationController
  before_action do
    authorize :options
  end

  before_action :set_option, only: [ :show, :update ]

  # GET /options
  def index
    @options = Option.all

    render json: @options
  end

  # GET /options/1
  def show
    render json: @option
  end

  # PATCH/PUT /options/1
  def update
    if @option.update option_params
      render json: @option
    else
      render json: @option.errors, status: :unprocessable_entity
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_option
      @option = Option.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def option_params
      params.permit(:name, :value)
    end
end
