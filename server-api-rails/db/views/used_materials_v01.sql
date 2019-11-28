SELECT materials.id AS material_id, projects.id AS project_id, projects.created_at, projects.solar_radiation_id
FROM materials
INNER JOIN component_materials ON component_materials.material_id = materials.id
INNER JOIN components ON components.id = component_materials.component_id
INNER JOIN faces ON faces.id = components.face_id
INNER JOIN rooms ON rooms.id = faces.room_id
INNER JOIN projects ON projects.id = rooms.project_id
WHERE materials.active IS TRUE
GROUP BY materials.id, projects.id, projects.created_at, projects.solar_radiation_id;
