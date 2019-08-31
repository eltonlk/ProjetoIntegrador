/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.thermalTransmittance;

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

/**
 *
 * @author nyko-
 */
public class ItemModal {

    private ArrayList<Material> materials;
    private Item item;
    private JComboBox materialsComboBox;
    private JTextField widthTextField;
    private JTextField resistanceTextField;

    public void add(Item item) {
        this.item = item;
        this.materials = new MaterialsController().list("");

        showModal("Adicionar Material");
    }

    public void edit(Item item) {
        this.item = item;
        this.materials = new MaterialsController().list("");

        showModal("Alterar Material");
    }

    private void showModal(String title) {
        this.materialsComboBox = newMaterialsComboBox();
        this.widthTextField = newWidthTextField();
        this.resistanceTextField = newResistanceTextField();

        int index = 0;
        if (item.getMaterial() != null) {
            for (Material material : materials) {
                if (item.getMaterial().getId() == material.getId()) {
                    index = materials.indexOf(material);
                }
            }
        }
        materialsComboBox.setSelectedIndex(index);

        widthTextField.setText("" + item.getWidth());

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

            if (result == JOptionPane.OK_OPTION && item.getThermalConductivity() == 0.0) {
                errors = "Espessura não pode ser ZERO.";
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
                item.setMaterial(material);
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
                item.setWidth(width);
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
        String resistance = "" + item.getThermalConductivity();

        resistanceTextField.setText(resistance);
    }
}
