class CreateMaterials < ActiveRecord::Migration[6.0]
  def change
    create_table :materials do |t|
      t.string  :name                      , null: false
      t.decimal :thermal_conductivity_index, default: 0, precision: 10, scale: 5
      t.boolean :active                    , default: true

      t.timestamps null: false
    end
  end
end
