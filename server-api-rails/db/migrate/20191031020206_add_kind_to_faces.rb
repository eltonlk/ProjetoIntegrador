class AddKindToFaces < ActiveRecord::Migration[6.0]
  def change
    add_column :faces, :kind, :integer, default: 0, null: false
  end
end
