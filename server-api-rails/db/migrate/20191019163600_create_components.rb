class CreateComponents < ActiveRecord::Migration[6.0]
  def change
    create_table :components do |t|
      t.string     :name     , null: false
      t.decimal    :area     , default: 0, precision: 10, scale: 5
      t.decimal    :heat_flow, default: 0, precision: 10, scale: 5
      t.references :face     , null: false, foreign_key: true
      t.references :color    , foreign_key: true

      t.timestamps null: false
    end
  end
end
