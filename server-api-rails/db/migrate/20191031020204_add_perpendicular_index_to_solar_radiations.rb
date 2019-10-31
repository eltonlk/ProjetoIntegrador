class AddPerpendicularIndexToSolarRadiations < ActiveRecord::Migration[6.0]
  def change
    add_column :solar_radiations, :perpendicular_index, :integer, default: 0, null: false
  end
end
