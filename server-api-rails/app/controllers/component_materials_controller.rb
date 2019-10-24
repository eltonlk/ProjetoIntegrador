class ComponentMaterialsController < ApplicationController
  before_action :set_component_material, only: [ :show, :update, :destroy ]

  # GET /component_materials
  def index
    @component_materials = ComponentMaterial.all

    render json: @component_materials
  end

  # GET /component_materials/1
  def show
    render json: @component_material
  end

  # POST /component_materials
  def create
    @component_material = ComponentMaterial.new component_material_params

    if @component_material.save
      render json: @component_material, status: :created, location: @component_material
    else
      render json: @component_material.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /component_materials/1
  def update
    if @component_material.update component_material_params
      render json: @component_material
    else
      render json: @component_material.errors, status: :unprocessable_entity
    end
  end

  # DELETE /component_materials/1
  def destroy
    @component_material.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_component_material
      @component_material = ComponentMaterial.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def component_material_params
      params.permit(:width, :thermal_conductivity_index, :component_id, :material_id)
    end
end
