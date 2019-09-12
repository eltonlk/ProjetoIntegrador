/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import controllers.ProjectsController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import resources.NumberParse;
import sources.Project;
import sources.ProjectMaterial;
import views.main.ApplicationView;

/**
 *
 * @author nyko-
 */
public class ProjectForm {

    private final Project project;
    private final String action;

    public ProjectForm(int id) {
        this.action = "update";
        this.project = new ProjectsController().find(id);
    }

    public ProjectForm() {
        this.action = "create";
        this.project = new Project();
    }

    public String getName() {
        return this.project.getName();
    }

    public void slabAddMaterial() {
        ProjectMaterial material = new ProjectMaterial();
        new ProjectMaterialForm().add(material);

        if (material.getMaterial() != null && material.getWidth() > 0) {
            project.addSlabMaterial(material);
        }
    }

    public void wallAddMaterial() {
        ProjectMaterial material = new ProjectMaterial();
        new ProjectMaterialForm().add(material);

        if (material.getMaterial() != null && material.getWidth() > 0) {
            project.addWallMaterial(material);
        }
    }

    public ArrayList<ProjectMaterial> getSlabMaterials() {
        return project.getSlabMaterials();
    }

    public ArrayList<ProjectMaterial> getWallMaterials() {
        return project.getWallMaterials();
    }

    public String getSlabThermalTransmittance() {
        double value = 0.17 + 0.04;

        for (ProjectMaterial material : getSlabMaterials()) {
            value += material.getThermalConductivity();
        }

        return NumberParse.localizeFromDouble(1 / value, "####0,00000");
    }

    public String getWallThermalTransmittance() {
        double value = 0.13 + 0.04;

        for (ProjectMaterial material : getWallMaterials()) {
            value += material.getThermalConductivity();
        }

        return NumberParse.localizeFromDouble(1 / value, "####0,00000");
    }

    public void save(String name) {
        project.setName(name);

        String errors;

        if ("update".equals(this.action)) {
            errors = new ProjectsController().update(this.project.getId(), project);
        } else {
            errors = new ProjectsController().create(project);
        }

        if (errors == null || errors.isEmpty()) {
            goBackToList();
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }
    }

    public void cancel() {
        goBackToList();
    }

    private void goBackToList() {
        views.projects.List frame = new views.projects.List();
        ApplicationView.changeInternalFrame(frame);
    }
}
