class ColorIdCanBeNullOnComponents < ActiveRecord::Migration[6.0]
  def change
    change_column :components, :color_id, :bigint, null: true
  end
end
