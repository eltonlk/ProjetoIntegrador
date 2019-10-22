class CreateUserRoles < ActiveRecord::Migration[6.0]
  def change
    create_table :user_roles do |t|
      t.references :user     , null: false
      t.references :role     , null: false
      t.references :privilege, null: false
      t.boolean    :enable   , null: false
    end

    add_foreign_key :user_roles, :users     , column: :user_id
    add_foreign_key :user_roles, :roles     , column: :role_id
    add_foreign_key :user_roles, :privileges, column: :privilege_id
  end
end
