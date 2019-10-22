class CreateSolarRadiations < ActiveRecord::Migration[6.0]
  def change
    create_table :solar_radiations do |t|
      t.string  :name            , null: false
      t.integer :north_index     , default: 0
      t.integer :north_east_index, default: 0
      t.integer :north_west_index, default: 0
      t.integer :south_index     , default: 0
      t.integer :south_east_index, default: 0
      t.integer :south_west_index, default: 0
      t.integer :east_index      , default: 0
      t.integer :west_index      , default: 0
      t.boolean :active          , default: true

      t.timestamps null: false
    end
  end
end
