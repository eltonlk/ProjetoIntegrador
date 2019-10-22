class CreateAudits < ActiveRecord::Migration[6.0]
  def change
    create_table :audits do |t|
      t.text     :content
      t.string   :modified_by
      t.datetime :modified_date
      t.string   :action       , null: false

      t.timestamps null: false
    end
  end
end
