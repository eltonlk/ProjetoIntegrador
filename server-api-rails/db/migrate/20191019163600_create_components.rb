class CreateComponents < ActiveRecord::Migration[6.0]
  def change
    create_table :components do |t|
      t.string     :name     , null: false
      t.decimal    :area     , default: 0, precision: 10, scale: 5
      t.decimal    :heat_flow, default: 0, precision: 10, scale: 5
      t.references :face
      t.references :color

      t.timestamps null: false
    end

    add_foreign_key :components, :faces , column: :face_id
    add_foreign_key :components, :colors, column: :color_id
  end
end
