class CreatePrivileges < ActiveRecord::Migration[6.0]
  def change
    create_table :privileges do |t|
      t.string :name, null: false

      t.timestamps null: false
    end
  end
end
