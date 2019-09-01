/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.main;

import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author nyko-
 */
public class ApplicationView extends javax.swing.JFrame {

    private static ApplicationView applicationView;

    /**
     * Creates new form MainView
     */
    public ApplicationView() {
        initComponents();

        this.applicationView = this;
    }

    public static void changeInternalFrame(Object object) {
        JInternalFrame frame = (JInternalFrame) object;
        frame.setBorder(null);

        BasicInternalFrameUI bi = (BasicInternalFrameUI) frame.getUI();
        bi.setNorthPane(null);

        applicationView.desktoPaine.removeAll();
        applicationView.desktoPaine.add(frame);
        frame.setVisible(true);

        // setMaximum works only after setVisible
        try {
            frame.setMaximum(true);
        } catch (PropertyVetoException ex) {
            System.out.println("Erro ao maximizar tela " + frame.getName() + ": " + ex);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        desktoPaine = new javax.swing.JDesktopPane();
        welcome = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu_cadastro = new javax.swing.JMenu();
        menuItemcategories = new javax.swing.JMenuItem();
        menuItemMaterials = new javax.swing.JMenuItem();
        menu_calculator = new javax.swing.JMenu();
        menuItemCaculateThermalTransmittance = new javax.swing.JMenuItem();
        menu_audits = new javax.swing.JMenu();
        menuItemAudits = new javax.swing.JMenuItem();
        menu_options = new javax.swing.JMenu();
        menuItemOptions = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arquitetando");
        setPreferredSize(new java.awt.Dimension(400, 250));

        desktoPaine.setBackground(new java.awt.Color(240, 240, 240));

        welcome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        welcome.setText("Bem Vindo");

        desktoPaine.setLayer(welcome, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktoPaineLayout = new javax.swing.GroupLayout(desktoPaine);
        desktoPaine.setLayout(desktoPaineLayout);
        desktoPaineLayout.setHorizontalGroup(
            desktoPaineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktoPaineLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(welcome)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        desktoPaineLayout.setVerticalGroup(
            desktoPaineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktoPaineLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(welcome)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        menu_cadastro.setText("Cadastros");

        menuItemcategories.setText("Categorias");
        menuItemcategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemcategoriesActionPerformed(evt);
            }
        });
        menu_cadastro.add(menuItemcategories);

        menuItemMaterials.setText("Materiais");
        menuItemMaterials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMaterialsActionPerformed(evt);
            }
        });
        menu_cadastro.add(menuItemMaterials);

        menuBar.add(menu_cadastro);

        menu_calculator.setText("Calculo");

        menuItemCaculateThermalTransmittance.setText("Calcular Transmitância Térmica");
        menuItemCaculateThermalTransmittance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCaculateThermalTransmittanceActionPerformed(evt);
            }
        });
        menu_calculator.add(menuItemCaculateThermalTransmittance);

        menuBar.add(menu_calculator);

        menu_audits.setText("Auditoria");

        menuItemAudits.setText("Listagem");
        menuItemAudits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAuditsActionPerformed(evt);
            }
        });
        menu_audits.add(menuItemAudits);

        menuBar.add(menu_audits);

        menu_options.setText("Configurações");

        menuItemOptions.setText("Configurações");
        menuItemOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOptionsActionPerformed(evt);
            }
        });
        menu_options.add(menuItemOptions);

        menuBar.add(menu_options);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktoPaine)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktoPaine, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemMaterialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMaterialsActionPerformed
        views.materials.List frame = new views.materials.List();
        changeInternalFrame(frame);
    }//GEN-LAST:event_menuItemMaterialsActionPerformed

    private void menuItemcategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemcategoriesActionPerformed
        views.categories.List frame = new views.categories.List();
        changeInternalFrame(frame);
    }//GEN-LAST:event_menuItemcategoriesActionPerformed

    private void menuItemOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOptionsActionPerformed
        views.options.Config frame = new views.options.Config();
        changeInternalFrame(frame);
    }//GEN-LAST:event_menuItemOptionsActionPerformed

    private void menuItemAuditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAuditsActionPerformed
        views.audits.List frame = new views.audits.List();
        changeInternalFrame(frame);
    }//GEN-LAST:event_menuItemAuditsActionPerformed

    private void menuItemCaculateThermalTransmittanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCaculateThermalTransmittanceActionPerformed
        views.thermalTransmittance.Calculate frame = new views.thermalTransmittance.Calculate();
        changeInternalFrame(frame);
    }//GEN-LAST:event_menuItemCaculateThermalTransmittanceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ApplicationView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktoPaine;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemAudits;
    private javax.swing.JMenuItem menuItemCaculateThermalTransmittance;
    private javax.swing.JMenuItem menuItemMaterials;
    private javax.swing.JMenuItem menuItemOptions;
    private javax.swing.JMenuItem menuItemcategories;
    private javax.swing.JMenu menu_audits;
    private javax.swing.JMenu menu_cadastro;
    private javax.swing.JMenu menu_calculator;
    private javax.swing.JMenu menu_options;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
