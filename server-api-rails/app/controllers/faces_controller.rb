class FacesController < ApplicationController
  before_action :set_face, only: [ :update, :destroy ]

  def create
    @face = Face.create! face_params

    render json: @face, status: :created
  end

  def update
    @face.update face_params

    head :no_content
  end

  def destroy
    @face.destroy

    head :no_content
  end

  private
    def face_params
      params.require(:face).permit(:name, :orientation, :room_id)
    end

    def set_face
      @face = Face.find params.require(:id)
    end
end
