require 'csv'

class MaterialsController < ApplicationController
  before_action do
    authorize :materials
  end

  before_action :set_material, only: [ :show, :update, :destroy ]

  # GET /materials
  def index
    @materials = Material.all

    render json: @materials
  end

  # GET /materials/1
  def show
    render json: @material
  end

  # POST /materials
  def create
    @material = Material.new material_params

    if @material.save
      render json: @material, status: :created, location: @material
    else
      render json: @material.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /materials/1
  def update
    if @material.update material_params
      render json: @material
    else
      render json: @material.errors, status: :unprocessable_entity
    end
  end

  # DELETE /materials/1
  def destroy
    @material.destroy
  end

  # POST /materials/import
  def import
    @materials = []

    CSV.foreach(params.require(:file).path, headers: true).with_index do |linha, index|
      next if index.zero?

      @materials << Material.create(name: row[0], kind: row[1], thermal_conductivity_index: row[2], solar_factor: row[3], resistance: row[4])
    end

    render json: @materials.select(&:persisted?)
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_material
      @material = Material.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def material_params
      params.permit(:name, :kind, :thermal_conductivity_index, :solar_factor, :resistance, :active)
    end
end
