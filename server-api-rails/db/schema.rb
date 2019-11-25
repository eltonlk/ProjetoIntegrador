# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# This file is the source Rails uses to define your schema when running `rails
# db:schema:load`. When creating a new database, `rails db:schema:load` tends to
# be faster and is potentially less error prone than running all of your
# migrations from scratch. Old migrations may fail to apply correctly if those
# migrations use external dependencies or application code.
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2019_11_24_155007) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "audits", force: :cascade do |t|
    t.integer "auditable_id"
    t.string "auditable_type"
    t.integer "associated_id"
    t.string "associated_type"
    t.integer "user_id"
    t.string "user_type"
    t.string "username"
    t.string "action"
    t.text "audited_changes"
    t.integer "version", default: 0
    t.string "comment"
    t.string "remote_address"
    t.string "request_uuid"
    t.datetime "created_at"
    t.index ["associated_type", "associated_id"], name: "associated_index"
    t.index ["auditable_type", "auditable_id", "version"], name: "auditable_index"
    t.index ["created_at"], name: "index_audits_on_created_at"
    t.index ["request_uuid"], name: "index_audits_on_request_uuid"
    t.index ["user_id", "user_type"], name: "user_index"
  end

  create_table "colors", force: :cascade do |t|
    t.string "name", null: false
    t.decimal "absorbability_index", precision: 10, scale: 5, default: "0.0"
    t.boolean "active", default: true
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  create_table "component_materials", force: :cascade do |t|
    t.decimal "width", precision: 5, scale: 3, default: "0.0"
    t.decimal "thermal_conductivity_index", precision: 10, scale: 5, default: "0.0"
    t.decimal "resistance", precision: 10, scale: 5, default: "0.0"
    t.bigint "component_id", null: false
    t.bigint "material_id", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.integer "kind", default: 0, null: false
    t.decimal "solar_factor", precision: 10, scale: 5, default: "0.0"
    t.index ["component_id"], name: "index_component_materials_on_component_id"
    t.index ["material_id"], name: "index_component_materials_on_material_id"
  end

  create_table "components", force: :cascade do |t|
    t.string "name", null: false
    t.decimal "area", precision: 10, scale: 5, default: "0.0"
    t.decimal "heat_flow", precision: 10, scale: 5, default: "0.0"
    t.bigint "face_id", null: false
    t.bigint "color_id"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["color_id"], name: "index_components_on_color_id"
    t.index ["face_id"], name: "index_components_on_face_id"
  end

  create_table "faces", force: :cascade do |t|
    t.string "orientation", null: false
    t.decimal "heat_flow", precision: 10, scale: 5, default: "0.0"
    t.bigint "room_id", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.integer "kind", default: 0, null: false
    t.index ["room_id"], name: "index_faces_on_room_id"
  end

  create_table "materials", force: :cascade do |t|
    t.string "name", null: false
    t.decimal "thermal_conductivity_index", precision: 10, scale: 5, default: "0.0"
    t.boolean "active", default: true
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.integer "kind", default: 0, null: false
    t.decimal "solar_factor", precision: 10, scale: 5, default: "0.0"
    t.decimal "resistance", precision: 10, scale: 5, default: "0.0"
  end

  create_table "options", force: :cascade do |t|
    t.string "name", null: false
    t.string "value"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  create_table "privileges", force: :cascade do |t|
    t.string "name", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  create_table "privileges_roles", id: false, force: :cascade do |t|
    t.bigint "role_id", null: false
    t.bigint "privilege_id", null: false
    t.index ["role_id", "privilege_id"], name: "index_privileges_roles_on_role_id_and_privilege_id"
  end

  create_table "projects", force: :cascade do |t|
    t.string "name", null: false
    t.integer "season", null: false
    t.integer "external_temperature", default: 0
    t.integer "internal_temperature", default: 0
    t.bigint "solar_radiation_id", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["solar_radiation_id"], name: "index_projects_on_solar_radiation_id"
  end

  create_table "roles", force: :cascade do |t|
    t.string "name", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  create_table "rooms", force: :cascade do |t|
    t.string "name", null: false
    t.decimal "heat_load", precision: 10, scale: 5, default: "0.0"
    t.bigint "project_id", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["project_id"], name: "index_rooms_on_project_id"
  end

  create_table "solar_radiations", force: :cascade do |t|
    t.string "name", null: false
    t.integer "north_index", default: 0
    t.integer "north_east_index", default: 0
    t.integer "north_west_index", default: 0
    t.integer "south_index", default: 0
    t.integer "south_east_index", default: 0
    t.integer "south_west_index", default: 0
    t.integer "east_index", default: 0
    t.integer "west_index", default: 0
    t.boolean "active", default: true
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.integer "perpendicular_index", default: 0, null: false
  end

  create_table "user_roles", force: :cascade do |t|
    t.bigint "user_id", null: false
    t.bigint "role_id", null: false
    t.bigint "privilege_id", null: false
    t.boolean "enable", default: false, null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["privilege_id"], name: "index_user_roles_on_privilege_id"
    t.index ["role_id"], name: "index_user_roles_on_role_id"
    t.index ["user_id"], name: "index_user_roles_on_user_id"
  end

  create_table "users", force: :cascade do |t|
    t.string "name", null: false
    t.string "email", null: false
    t.string "username", null: false
    t.string "password_digest", null: false
    t.boolean "active", default: true, null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
  end

  add_foreign_key "component_materials", "components"
  add_foreign_key "component_materials", "materials"
  add_foreign_key "components", "colors"
  add_foreign_key "components", "faces"
  add_foreign_key "faces", "rooms"
  add_foreign_key "privileges_roles", "privileges"
  add_foreign_key "privileges_roles", "roles"
  add_foreign_key "projects", "solar_radiations"
  add_foreign_key "rooms", "projects"
  add_foreign_key "user_roles", "privileges"
  add_foreign_key "user_roles", "roles"
  add_foreign_key "user_roles", "users"

  create_view "used_materials", sql_definition: <<-SQL
      SELECT mat.id,
      count(pro.*) AS count
     FROM (((((materials mat
       LEFT JOIN component_materials cma ON ((cma.material_id = mat.id)))
       LEFT JOIN components com ON ((com.id = cma.component_id)))
       LEFT JOIN faces fac ON ((fac.id = com.face_id)))
       LEFT JOIN rooms roo ON ((roo.id = fac.room_id)))
       LEFT JOIN projects pro ON ((pro.id = roo.project_id)))
    WHERE (mat.active IS TRUE)
    GROUP BY mat.id;
  SQL
end
