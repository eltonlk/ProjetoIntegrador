class CreateAfterInsertPrivilegesRolesTrigger < ActiveRecord::Migration[6.0]
  def change
    execute <<-SQL
      CREATE OR REPLACE FUNCTION after_create_privileges_roles_insert_user_rules_function() RETURNS TRIGGER
        LANGUAGE plpgsql AS
        $$BEGIN
          INSERT INTO user_roles(user_id, role_id, privilege_id, created_at, updated_at)
          SELECT users.id, NEW.role_id, NEW.privilege_id, users.created_at, users.updated_at FROM users;
          RETURN NEW;
      END;$$;

      CREATE TRIGGER after_create_privileges_roles_insert_user_rules
        AFTER INSERT ON public.privileges_roles FOR EACH ROW
        EXECUTE PROCEDURE after_create_privileges_roles_insert_user_rules_function()
    SQL
  end
end
