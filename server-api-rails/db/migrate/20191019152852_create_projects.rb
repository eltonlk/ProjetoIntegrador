class CreateProjects < ActiveRecord::Migration[6.0]
  def change
    create_table :projects do |t|
      t.string     :name                , null: false
      t.integer    :season              , null: false
      t.integer    :external_temperature, default: 0
      t.integer    :internal_temperature, default: 0
      t.references :solar_radiation     , null: false, foreign_key: true

      t.timestamps null: false
    end
  end
end
