class CreateAfterInsertUserTrigger < ActiveRecord::Migration[6.0]
  def change
    execute <<-SQL
      CREATE OR REPLACE FUNCTION after_create_user_insert_user_rules_function() RETURNS TRIGGER
        LANGUAGE plpgsql AS
        $$BEGIN
          INSERT INTO user_roles(user_id, role_id, privilege_id, created_at, updated_at)
          SELECT NEW.id, role_id, privilege_id, NEW.created_at, NEW.updated_at FROM privileges_roles;
          RETURN NEW;
      END;$$;

      CREATE TRIGGER after_create_user_insert_user_rules
        AFTER INSERT ON public.users FOR EACH ROW
        EXECUTE PROCEDURE after_create_user_insert_user_rules_function()
    SQL
  end
end
