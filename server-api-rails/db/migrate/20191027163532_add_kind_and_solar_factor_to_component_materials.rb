class AddKindAndSolarFactorToComponentMaterials < ActiveRecord::Migration[6.0]
  def change
    add_column :component_materials, :kind        , :integer, default: 0, null: false
    add_column :component_materials, :solar_factor, :decimal, default: 0, precision: 10, scale: 5
  end
end
