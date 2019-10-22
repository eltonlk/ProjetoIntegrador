class ComponentMaterialsController < ApplicationController
  before_action :set_component_material, only: [ :update, :destroy ]

  def create
    @component_material = ComponentMaterial.create! component_material_params

    render json: @component_material, status: :created
  end

  def update
    @component_material.update component_material_params

    head :no_content
  end

  def destroy
    @component_material.destroy

    head :no_content
  end

  private
    def component_material_params
      params.require(:component_material).permit(:width, :thermal_conductitity_index, :component_id, :material_id)
    end

    def set_component_material
      @component_material = ComponentMaterial.find params.require(:id)
    end
end
