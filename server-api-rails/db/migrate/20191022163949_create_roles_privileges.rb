class CreateRolesPrivileges < ActiveRecord::Migration[6.0]
  def change
    create_table :privileges_roles do |t|
      t.references :role     , null: false
      t.references :privilege, null: false
    end

    add_foreign_key :privileges_roles, :roles     , column: :role_id
    add_foreign_key :privileges_roles, :privileges, column: :privilege_id
  end
end
