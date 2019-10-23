class CreateFaces < ActiveRecord::Migration[6.0]
  def change
    create_table :faces do |t|
      t.string     :name       , null: false
      t.string     :orientation, null: false
      t.decimal    :heat_flow  , default: 0, precision: 10, scale: 5
      t.references :room       , null: false, foreign_key: true

      t.timestamps null: false
    end
  end
end
