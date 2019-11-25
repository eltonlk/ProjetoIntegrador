class CreateUsedMaterials < ActiveRecord::Migration[6.0]
  def change
    create_view :used_materials
  end
end
