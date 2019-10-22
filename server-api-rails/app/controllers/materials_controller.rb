class MaterialsController < ApplicationController
  before_action :set_material, only: [ :update, :destroy ]

  def index
    @materials = Material.all

    render json: @materials, status: :ok
  end

  def create
    @material = Material.create! material_params

    render json: @material, status: :created
  end

  def update
    @material.update material_params

    head :no_content
  end

  def destroy
    @material.destroy

    head :no_content
  end

  private
    def material_params
      params.require(:material).permit(:name, :thermal_conductitity_index, :active)
    end

    def set_material
      @material = Material.find params.require(:id)
    end
end
