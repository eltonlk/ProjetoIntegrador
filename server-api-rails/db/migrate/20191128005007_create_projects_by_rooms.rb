class CreateProjectsByRooms < ActiveRecord::Migration[6.0]
  def change
    create_view :projects_by_rooms
  end
end
