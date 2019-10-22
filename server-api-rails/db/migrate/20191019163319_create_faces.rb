class CreateFaces < ActiveRecord::Migration[6.0]
  def change
    create_table :faces do |t|
      t.string     :name       , null: false
      t.string     :orientation, null: false
      t.decimal    :heat_flow  , default: 0, precision: 10, scale: 5
      t.references :room

      t.timestamps null: false
    end

    add_foreign_key :faces, :rooms, column: :room_id
  end
end
