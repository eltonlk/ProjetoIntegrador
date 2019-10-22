class SolarRadiationsController < ApplicationController
  before_action :set_solar_radiation, only: [ :show, :update, :destroy ]

  def index
    @solar_radiations = SolarRadiation.all

    render json: @solar_radiations, status: :ok
  end

  def create
    @solar_radiation = SolarRadiation.create! solar_radiation_params

    render json: @solar_radiation, status: :created
  end

  def update
    @solar_radiation.update solar_radiation_params

    head :no_content
  end

  def destroy
    @solar_radiation.destroy

    head :no_content
  end

  private
    def solar_radiation_params
      params.require(:solar_radiation).permit(:name, :north_index, :north_east_index, :north_west_index,
        :south_index, :south_east_index, :south_west_index, :east_index, :west_index)
    end

    def set_solar_radiation
      @solar_radiation = SolarRadiation.find params.require(:id)
    end
end
