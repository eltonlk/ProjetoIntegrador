/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import controllers.MaterialsController;
import javax.swing.JOptionPane;
import resources.NumberParse;
import sources.Material;
import views.main.ApplicationView;

/**
 *
 * @author nyko-
 */
public class MaterialForm {

    private final Material material;
    private final String action;

    public MaterialForm(int id) {
        this.action = "update";
        this.material = new MaterialsController().find(id);
    }

    public MaterialForm() {
        this.action = "create";
        this.material = new Material();
    }

    public String getName() {
        return this.material.getName();
    }

    public double getThermalConductivityIndex() {
        return this.material.getThermalConductivityIndex();
    }

    public boolean isInactive() {
        return this.material.isInactive();
    }

    public boolean isActive() {
        return this.material.isActive();
    }

    public void save(String name, String thermalConductivityIndex, boolean active) {
        Material newMaterial = new Material();
        newMaterial.setName(name);
        newMaterial.setThermalConductivityIndex(NumberParse.parseToDouble(thermalConductivityIndex));
        newMaterial.setActive(active);

        String errors;

        if ("update".equals(this.action)) {
            errors = new MaterialsController().update(this.material.getId(), newMaterial);
        } else {
            errors = new MaterialsController().create(newMaterial);
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
        views.materials.List frame = new views.materials.List();
        ApplicationView.changeInternalFrame(frame);
    }
}
