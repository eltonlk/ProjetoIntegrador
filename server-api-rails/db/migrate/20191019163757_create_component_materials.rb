class CreateComponentMaterials < ActiveRecord::Migration[6.0]
  def change
    create_table :component_materials do |t|
      t.decimal    :width                     , default: 0, precision: 5, scale: 3
      t.decimal    :thermal_conductivity_index, default: 0, precision: 10, scale: 5
      t.decimal    :resistance                , default: 0, precision: 10, scale: 5
      t.references :component                 , null: false, foreign_key: true
      t.references :material                  , null: false, foreign_key: true

      t.timestamps null: false
    end
  end
end
