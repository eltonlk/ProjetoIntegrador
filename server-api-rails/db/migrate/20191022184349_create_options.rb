class CreateOptions < ActiveRecord::Migration[6.0]
  def change
    create_table :options do |t|
      t.string :name , null: false
      t.string :value

      t.timestamps null: false
    end
  end
end
