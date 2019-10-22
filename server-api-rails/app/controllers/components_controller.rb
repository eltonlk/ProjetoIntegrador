class ComponentsController < ApplicationController
  before_action :set_component, only: [ :update, :destroy ]

  def create
    @component = Component.create! component_params

    render json: @component, status: :created
  end

  def update
    @component.update component_params

    head :no_content
  end

  def destroy
    @component.destroy

    head :no_content
  end

  private
    def component_params
      params.require(:component).permit(:name, :area, :face_id, :color_id)
    end

    def set_component
      @component = Component.find params.require(:id)
    end
end
