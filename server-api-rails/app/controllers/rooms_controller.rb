class RoomsController < ApplicationController
  before_action :set_room, only: [ :update, :destroy ]

  def create
    @room = Room.create! room_params

    render json: @room, status: :created
  end

  def update
    @room.update room_params

    head :no_content
  end

  def destroy
    @room.destroy

    head :no_content
  end

  private
    def room_params
      params.require(:room).permit(:name, :project_id)
    end

    def set_room
      @room = Room.find params.require(:id)
    end
end
