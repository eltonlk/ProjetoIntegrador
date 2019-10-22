class CreateUserRoles < ActiveRecord::Migration[6.0]
  def change
    create_table :user_roles do |t|
      t.references :user     , null: false, foreign_key: true
      t.references :role     , null: false, foreign_key: true
      t.references :privilege, null: false, foreign_key: true
      t.boolean    :enable   , null: false, default: false

      t.timestamps
    end
  end
end
