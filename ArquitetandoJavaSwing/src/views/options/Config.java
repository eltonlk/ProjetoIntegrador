/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.options;

import controllers.OptionsController;
import java.awt.Font;
import javax.swing.JOptionPane;
import sources.Option;

/**
 *
 * @author nyko-
 */
public class Config extends javax.swing.JInternalFrame {

    private Option option = null;

    /**
     * Creates new form List
     */
    public Config() {
        initComponents();

        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

        option = new OptionsController().list().get(0);

        if ("enabled".equals(option.getValue())) {
            rb_active.setSelected(true);
            rb_inactive.setSelected(false);
        } else {
            rb_active.setSelected(false);
            rb_inactive.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_submit = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        rb_active = new javax.swing.JRadioButton();
        rb_inactive = new javax.swing.JRadioButton();

        btn_submit.setText("Atualizar");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        titleLabel.setText("Opções do Sistema");

        lbl_status.setText("Auditar registros:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_active)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_inactive))
                            .addComponent(lbl_status)
                            .addComponent(btn_submit))
                        .addGap(0, 543, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_active)
                    .addComponent(rb_inactive))
                .addGap(18, 18, 18)
                .addComponent(btn_submit)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_activeActionPerformed
        rb_active.setSelected(true);
        rb_inactive.setSelected(false);
    }//GEN-LAST:event_rb_activeActionPerformed

    private void rb_inactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_inactiveActionPerformed
        rb_active.setSelected(false);
        rb_inactive.setSelected(true);
    }//GEN-LAST:event_rb_inactiveActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        if (rb_active.isSelected()) {
            option.setValue("enabled");
        } else {
            option.setValue("disabled");
        }

        String errors = new OptionsController().update(option.getId(), option);

        if (errors == null || errors.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Atualizado");
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }
    }//GEN-LAST:event_btn_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_submit;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JRadioButton rb_active;
    private javax.swing.JRadioButton rb_inactive;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
