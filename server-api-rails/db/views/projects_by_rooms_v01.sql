SELECT projects.id AS project_id, COUNT(rooms.*) AS rooms, projects.created_at, projects.solar_radiation_id
FROM projects
LEFT JOIN rooms ON rooms.project_id = projects.id
GROUP BY projects.id, projects.created_at, projects.solar_radiation_id;
