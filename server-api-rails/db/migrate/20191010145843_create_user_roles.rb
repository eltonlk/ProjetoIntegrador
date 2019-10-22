class CreateUserRoles < ActiveRecord::Migration[6.0]
  def change
    create_table :user_roles do |t|
      t.references :user     , null: false, foreign_key: true
      t.references :role     , null: false, foreign_key: true
      t.references :privilege, null: false, foreign_key: true
      t.boolean    :enable   , null: false, default: false

      t.timestamps null: false
    end

    add_foreign_key :user_roles, :users     , column: :user_id
    add_foreign_key :user_roles, :roles     , column: :role_id
    add_foreign_key :user_roles, :privileges, column: :privilege_id
  end
end
