class CreateRooms < ActiveRecord::Migration[6.0]
  def change
    create_table :rooms do |t|
      t.string     :name     , null: false
      t.decimal    :heat_load, default: 0, precision: 10, scale: 5
      t.references :project  , null: false, foreign_key: true

      t.timestamps null: false
    end
  end
end
