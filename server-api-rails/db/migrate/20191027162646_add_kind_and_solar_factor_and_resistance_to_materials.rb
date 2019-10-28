class AddKindAndSolarFactorAndResistanceToMaterials < ActiveRecord::Migration[6.0]
  def change
    add_column :materials, :kind        , :integer, default: 0, null: false
    add_column :materials, :solar_factor, :decimal, default: 0, precision: 10, scale: 5
    add_column :materials, :resistance  , :decimal, default: 0, precision: 10, scale: 5
  end
end
