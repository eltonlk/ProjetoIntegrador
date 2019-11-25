SELECT mat.id, COUNT(pro.*)
FROM materials mat
LEFT JOIN component_materials cma ON cma.material_id = mat.id
LEFT JOIN components com ON com.id = cma.component_id
LEFT JOIN faces fac ON fac.id = com.face_id
LEFT JOIN rooms roo ON roo.id = fac.room_id
LEFT JOIN projects pro ON pro.id = roo.project_id
WHERE mat.active IS TRUE
GROUP BY mat.id;
