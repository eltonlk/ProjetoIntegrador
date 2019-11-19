require 'csv'

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

  # POST /solar_radiations/import
  def import
    @solar_radiations = []

    CSV.foreach(params.require(:file).path, headers: true).with_index do |linha, index|
      next if index.zero?

      @solar_radiations << SolarRadiation.create(name: row[0], north_index: row[1], north_east_index: row[2],
        north_west_index: row[3], south_index: row[4], south_east_index: row[5], south_west_index: row[6],
        east_index: row[7], west_index: row[8], perpendicular_index: row[9])
    end

    render json: @solar_radiations.select(&:persisted?)
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_solar_radiation
      @solar_radiation = SolarRadiation.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def solar_radiation_params
      params.permit(:name, :north_index, :north_east_index, :north_west_index,
        :south_index, :south_east_index, :south_west_index, :east_index, :west_index,
        :perpendicular_index)
    end
end
