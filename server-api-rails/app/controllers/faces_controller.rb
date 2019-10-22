class FacesController < ApplicationController
  before_action :set_face, only: [ :show, :update, :destroy ]

  # GET /faces
  def index
    @faces = Face.all

    render json: @faces
  end

  # GET /faces/1
  def show
    render json: @face
  end

  # POST /faces
  def create
    @face = Face.new face_params

    if @face.save
      render json: @face, status: :created, location: @face
    else
      render json: @face.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /faces/1
  def update
    if @face.update face_params
      render json: @face
    else
      render json: @face.errors, status: :unprocessable_entity
    end
  end

  # DELETE /faces/1
  def destroy
    @face.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_face
      @face = Face.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def face_params
      params.permit(:name, :orientation, :room_id)
    end
end
