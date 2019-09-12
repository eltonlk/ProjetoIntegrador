/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import controllers.MaterialsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import sources.Material;
import sources.ProjectMaterial;

/**
 *
 * @author nyko-
 */
public class ProjectMaterialForm {

    private ArrayList<Material> materials;
    private ProjectMaterial projectMaterial;
    private JComboBox materialsComboBox;
    private JTextField widthTextField;
    private JTextField resistanceTextField;

    public void add(ProjectMaterial projectMaterial) {
        this.projectMaterial = projectMaterial;
        this.materials = new MaterialsController().list("");

        showModal("Adicionar Material");
    }

    public void edit(ProjectMaterial projectMaterial) {
        this.projectMaterial = projectMaterial;
        this.materials = new MaterialsController().list("");

        showModal("Alterar Material");
    }

    private void showModal(String title) {
        this.materialsComboBox = newMaterialsComboBox();
        this.widthTextField = newWidthTextField();
        this.resistanceTextField = newResistanceTextField();

        int index = 0;
        if (projectMaterial.getMaterial() != null) {
            for (Material material : materials) {
                if (projectMaterial.getMaterial().getId() == material.getId()) {
                    index = materials.indexOf(material);
                }
            }
        }
        materialsComboBox.setSelectedIndex(index);

        widthTextField.setText("" + projectMaterial.getWidth());

        Object[] message = {
            "* Material:", this.materialsComboBox,
            "* Espessura (m):", this.widthTextField,
            "Resistência Térmica:", this.resistanceTextField
        };

        String errors = null;

        do {
            if (errors != null) {
                JOptionPane.showMessageDialog(null, errors);
            }

            int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION && projectMaterial.getThermalConductivity() == 0.0) {
                errors = "Espessura deve ser maior que ZERO.";
            } else {
                errors = null;
            }
        } while (errors != null);
    }

    private JComboBox newMaterialsComboBox() {
        JComboBox<Object> comboBox = new JComboBox<>(materials.toArray());

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<Material> combo = (JComboBox<Material>) e.getSource();
                Material material = (Material) combo.getSelectedItem();
                projectMaterial.setMaterial(material);
                calculateResistence();
            }
        });

        return comboBox;
    }

    private JTextField newWidthTextField() {
        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String text = textField.getText();
                double width = Double.parseDouble(text.replace(".", "").replace(",", "."));
                textField.setText("" + width);
                projectMaterial.setWidth(width);
                calculateResistence();
            }
        });

        return textField;
    }

    private JTextField newResistanceTextField() {
        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);

        return textField;
    }

    private void calculateResistence() {
        String resistance = "" + projectMaterial.getThermalConductivity();

        resistanceTextField.setText(resistance);
    }
}
