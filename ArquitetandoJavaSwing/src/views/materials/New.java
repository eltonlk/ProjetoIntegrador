/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.materials;

import controllers.MaterialsController;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import resources.NumberFormater;
import sources.Material;
import views.main.ApplicationView;

/**
 *
 * @author nyko-
 */
public class New extends javax.swing.JInternalFrame {

    /**
     * Creates new form New
     */
    public New() {
        initComponents();
        initFields();
    }

    private void initFields() {
        this.rb_active.setSelected(true);
        
        this.ftf_thermalConductivityIndex = new JFormattedTextField(NumberFormater.newDecimal(5, 5));
        this.ftf_thermalConductivityIndex.setValue(0.0);
        
        this.btn_cancel.setForeground(Color.RED);
    }

    private Material buildMaterial() {
        String name = tf_name.getText();
        boolean active = rb_active.isSelected();
        double thermaConductivity = Double.parseDouble(ftf_thermalConductivityIndex.getText());

        Material material = new Material();
        material.setName(name);
        material.setActive(active);

        return material;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        mainPane = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        lbl_status = new javax.swing.JLabel();
        rb_active = new javax.swing.JRadioButton();
        rb_inactive = new javax.swing.JRadioButton();
        lbl_thermalConductivityIndex = new javax.swing.JLabel();
        ftf_thermalConductivityIndex = new javax.swing.JFormattedTextField();
        btn_submit = new javax.swing.JButton();
        lbl_or = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();

        btn_back.setText("Voltar");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        lbl_name.setText("* Nome:");

        lbl_status.setText("* Situação:");

        rb_active.setText("Ativo");
        rb_active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_activeActionPerformed(evt);
            }
        });

        rb_inactive.setText("Inativo");
        rb_inactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_inactiveActionPerformed(evt);
            }
        });

        lbl_thermalConductivityIndex.setText("* Indice Cond. Term.:");

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_name)
                    .addGroup(mainPaneLayout.createSequentialGroup()
                        .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_name)
                            .addComponent(lbl_status)
                            .addGroup(mainPaneLayout.createSequentialGroup()
                                .addComponent(rb_active)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_inactive))
                            .addComponent(lbl_thermalConductivityIndex))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ftf_thermalConductivityIndex))
                .addContainerGap())
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_active)
                    .addComponent(rb_inactive))
                .addGap(18, 18, 18)
                .addComponent(lbl_thermalConductivityIndex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftf_thermalConductivityIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_submit.setText("Adicionar");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        lbl_or.setText("ou");

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addContainerGap())
            .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_or)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cancel)
                .addContainerGap(410, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back)
                .addGap(18, 18, 18)
                .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_or)
                    .addComponent(btn_submit)
                    .addComponent(btn_cancel))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        List frame = new List();
        ApplicationView.changeInternalFrame(frame);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        Material newMaterial = buildMaterial();
        String errors = new MaterialsController().create(newMaterial);

        if (errors == null || errors.isEmpty()) {
            List frame = new List();
            ApplicationView.changeInternalFrame(frame);
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void rb_inactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_inactiveActionPerformed
        rb_active.setSelected(false);
        rb_inactive.setSelected(true);
    }//GEN-LAST:event_rb_inactiveActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        List frame = new List();
        ApplicationView.changeInternalFrame(frame);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void rb_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_activeActionPerformed
        rb_active.setSelected(true);
        rb_inactive.setSelected(false);
    }//GEN-LAST:event_rb_activeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_submit;
    private javax.swing.JFormattedTextField ftf_thermalConductivityIndex;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_or;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_thermalConductivityIndex;
    private javax.swing.JPanel mainPane;
    private javax.swing.JRadioButton rb_active;
    private javax.swing.JRadioButton rb_inactive;
    private javax.swing.JTextField tf_name;
    // End of variables declaration//GEN-END:variables
}
