class CreateBeforeDeletePrivilegesRolesTrigger < ActiveRecord::Migration[6.0]
  def change
    execute <<-SQL
      CREATE OR REPLACE FUNCTION before_delete_privileges_roles_delete_user_rules_function() RETURNS TRIGGER
        LANGUAGE plpgsql AS
        $$BEGIN
          DELETE FROM user_roles WHERE role_id = OLD.role_id AND privilege_id = OLD.privilege_id;
          RETURN OLD;
      END;$$;

      CREATE TRIGGER before_delete_privileges_roles_delete_user_rules
        BEFORE DELETE ON public.privileges_roles FOR EACH ROW
        EXECUTE PROCEDURE before_delete_privileges_roles_delete_user_rules_function()
    SQL
  end
end
