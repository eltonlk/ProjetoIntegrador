class CreateJoinTableRolesPrivileges < ActiveRecord::Migration[6.0]
  def change
    create_join_table :roles, :privileges do |t|
      t.index [ :role_id, :privilege_id ]
    end
  end
end
