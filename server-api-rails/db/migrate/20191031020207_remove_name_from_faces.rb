class RemoveNameFromFaces < ActiveRecord::Migration[6.0]
  def change
    remove_column :faces, :name, :string
  end
end
