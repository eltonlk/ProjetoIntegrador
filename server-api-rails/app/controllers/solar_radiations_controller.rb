class SolarRadiationsController < ApplicationController
  before_action do
    authorize :solar_radiations
  end

  before_action :set_solar_radiation, only: [ :show, :update, :destroy ]

  # GET /solar_radiations
  def index
    @solar_radiations = SolarRadiation.all

    render json: @solar_radiations
  end

  # GET /solar_radiations/1
  def show
    render json: @solar_radiation
  end

  # POST /solar_radiations
  def create
    @solar_radiation = SolarRadiation.new solar_radiation_params

    if @solar_radiation.save
      render json: @solar_radiation, status: :created, location: @solar_radiation
    else
      render json: @solar_radiation.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /solar_radiations/1
  def update
    if @solar_radiation.update solar_radiation_params
      render json: @solar_radiation
    else
      render json: @solar_radiation.errors, status: :unprocessable_entity
    end
  end

  # DELETE /solar_radiations/1
  def destroy
    @solar_radiation.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_solar_radiation
      @solar_radiation = SolarRadiation.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def solar_radiation_params
      params.permit(:name, :north_index, :north_east_index, :north_west_index,
        :south_index, :south_east_index, :south_west_index, :east_index, :west_index)
    end
end
