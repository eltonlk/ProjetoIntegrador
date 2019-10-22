class ColorsController < ApplicationController
  before_action :set_color, only: [ :update, :destroy ]

  def index
    @colors = Color.all

    render json: @colors, status: :ok
  end

  def create
    @color = Color.create! color_params

    render json: @color, status: :created
  end

  def update
    @color.update color_params

    head :no_content
  end

  def destroy
    @color.destroy

    head :no_content
  end

  private
    def color_params
      params.require(:color).permit(:name, :absorbability_index)
    end

    def set_color
      @color = Color.find params.require(:id)
    end
end
