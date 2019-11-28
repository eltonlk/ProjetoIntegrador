class CreateProjectsByYearAndMonths < ActiveRecord::Migration[6.0]
  def change
    create_view :projects_by_year_and_months
  end
end
