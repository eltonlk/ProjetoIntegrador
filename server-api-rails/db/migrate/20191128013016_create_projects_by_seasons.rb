class CreateProjectsBySeasons < ActiveRecord::Migration[6.0]
  def change
    create_view :projects_by_seasons
  end
end
