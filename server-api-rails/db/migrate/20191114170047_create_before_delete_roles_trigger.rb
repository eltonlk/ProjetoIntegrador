class CreateBeforeDeleteRolesTrigger < ActiveRecord::Migration[6.0]
  def change
    execute <<-SQL
      CREATE OR REPLACE FUNCTION before_delete_roles_delete_privileges_rules_function() RETURNS TRIGGER
        LANGUAGE plpgsql AS
        $$BEGIN
          DELETE FROM privileges_rules WHERE role_id = OLD.role_id;
          RETURN OLD;
      END;$$;

      CREATE TRIGGER before_delete_roles_delete_privileges_rules
        BEFORE DELETE ON public.roles FOR EACH ROW
        EXECUTE PROCEDURE before_delete_roles_delete_privileges_rules_function()
    SQL
  end
end
