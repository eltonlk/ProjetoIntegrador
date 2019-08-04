/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.main;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import views.categorias.CategoriasListagem;

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

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(600, 400));
        
        applicationView = this;
    }

    public void changeInternalFrame(Object object) {
        JInternalFrame frame = (JInternalFrame) object;

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

        desktoPaine = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_cadastro = new javax.swing.JMenu();
        menuItem_categorias = new javax.swing.JMenuItem();
        menuItem_materiais = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arquitetando");
        setPreferredSize(new java.awt.Dimension(400, 250));

        desktoPaine.setBackground(new java.awt.Color(240, 240, 240));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Bem Vindo");

        javax.swing.GroupLayout desktoPaineLayout = new javax.swing.GroupLayout(desktoPaine);
        desktoPaine.setLayout(desktoPaineLayout);
        desktoPaineLayout.setHorizontalGroup(
            desktoPaineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktoPaineLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        desktoPaineLayout.setVerticalGroup(
            desktoPaineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktoPaineLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        desktoPaine.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menu_cadastro.setText("Cadastros");

        menuItem_categorias.setText("Categorias");
        menuItem_categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_categoriasActionPerformed(evt);
            }
        });
        menu_cadastro.add(menuItem_categorias);

        menuItem_materiais.setText("Materiais");
        menuItem_materiais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_materiaisActionPerformed(evt);
            }
        });
        menu_cadastro.add(menuItem_materiais);

        jMenuBar1.add(menu_cadastro);

        setJMenuBar(jMenuBar1);

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

    private void menuItem_materiaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_materiaisActionPerformed
//        MateriaisListagem view = new MateriaisListagem();
//        changeView(view);
        JOptionPane.showMessageDialog(null, "IMPLEMENTAR LSITAGEM DE MATERIAIS");
    }//GEN-LAST:event_menuItem_materiaisActionPerformed

    private void menuItem_categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_categoriasActionPerformed
        CategoriasListagem frame = new CategoriasListagem();
        changeInternalFrame(frame);
    }//GEN-LAST:event_menuItem_categoriasActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItem_categorias;
    private javax.swing.JMenuItem menuItem_materiais;
    private javax.swing.JMenu menu_cadastro;
    // End of variables declaration//GEN-END:variables
}
