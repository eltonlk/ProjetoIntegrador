/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.materiais;

import controllers.MateriaisController;
import java.awt.Color;
import javax.swing.JOptionPane;
import sources.Material;
import views.main.ApplicationView;

/**
 *
 * @author nyko-
 */
public class MateriaisAtualizar extends javax.swing.JInternalFrame {

    private final Material materialSalvo;

    /**
     * Creates new form MateriaisAtualizar
     */
    public MateriaisAtualizar(int id) {
        materialSalvo = new MateriaisController().procurar(id);

        initComponents();
        definirCampos();
    }

    public void definirCampos() {
        this.tf_nome.setText(materialSalvo.getNome());

        if (materialSalvo.isAtivo()) {
            this.rb_ativo.setSelected(true);
        } else {
            this.rb_inativo.setSelected(true);
        }

        this.btn_cancelar.setForeground(Color.RED);
    }

    public Material construirMaterial() {
        String nome = tf_nome.getText();
        boolean ativo = rb_ativo.isSelected();

        Material material = new Material();
        material.setNome(nome);

        if (ativo) {
            material.ativar();
        } else {
            material.inativar();
        }

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
        btn_submit = new javax.swing.JButton();
        lbl_ou = new javax.swing.JLabel();
        rowPane = new javax.swing.JPanel();
        col1Pane = new javax.swing.JPanel();
        lbl_nome = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        col2Pane = new javax.swing.JPanel();
        lbl_situacao = new javax.swing.JLabel();
        rb_ativo = new javax.swing.JRadioButton();
        rb_inativo = new javax.swing.JRadioButton();
        btn_cancelar = new javax.swing.JButton();

        btn_back.setText("Voltar");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_submit.setText("Atualizar");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        lbl_ou.setText("ou");

        lbl_nome.setText("* Nome:");

        javax.swing.GroupLayout col1PaneLayout = new javax.swing.GroupLayout(col1Pane);
        col1Pane.setLayout(col1PaneLayout);
        col1PaneLayout.setHorizontalGroup(
            col1PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(col1PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(col1PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(col1PaneLayout.createSequentialGroup()
                        .addComponent(lbl_nome)
                        .addGap(0, 227, Short.MAX_VALUE))
                    .addComponent(tf_nome))
                .addContainerGap())
        );
        col1PaneLayout.setVerticalGroup(
            col1PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(col1PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        lbl_situacao.setText("Situação:");

        rb_ativo.setText("Ativo");
        rb_ativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_ativoActionPerformed(evt);
            }
        });

        rb_inativo.setText("Inativo");
        rb_inativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_inativoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout col2PaneLayout = new javax.swing.GroupLayout(col2Pane);
        col2Pane.setLayout(col2PaneLayout);
        col2PaneLayout.setHorizontalGroup(
            col2PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(col2PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(col2PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(col2PaneLayout.createSequentialGroup()
                        .addComponent(rb_ativo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_inativo))
                    .addComponent(lbl_situacao))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        col2PaneLayout.setVerticalGroup(
            col2PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(col2PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_situacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(col2PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_ativo)
                    .addComponent(rb_inativo))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rowPaneLayout = new javax.swing.GroupLayout(rowPane);
        rowPane.setLayout(rowPaneLayout);
        rowPaneLayout.setHorizontalGroup(
            rowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rowPaneLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(col1Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(col2Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rowPaneLayout.setVerticalGroup(
            rowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rowPaneLayout.createSequentialGroup()
                .addGroup(rowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(col1Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(col2Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_back))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_submit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_ou)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(rowPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rowPane, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ou)
                    .addComponent(btn_submit)
                    .addComponent(btn_cancelar))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        MateriaisListagem frame = new MateriaisListagem();
        ApplicationView.changeInternalFrame(frame);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        Material material = construirMaterial();
        String errors = new MateriaisController().atualizar(materialSalvo.getId(), material);

        if (errors == null || errors.isEmpty()) {
            MateriaisListagem frame = new MateriaisListagem();
            ApplicationView.changeInternalFrame(frame);
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void rb_ativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_ativoActionPerformed
        rb_ativo.setSelected(true);
        rb_inativo.setSelected(false);
    }//GEN-LAST:event_rb_ativoActionPerformed

    private void rb_inativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_inativoActionPerformed
        rb_ativo.setSelected(false);
        rb_inativo.setSelected(true);
    }//GEN-LAST:event_rb_inativoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        MateriaisListagem frame = new MateriaisListagem();
        ApplicationView.changeInternalFrame(frame);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_submit;
    private javax.swing.JPanel col1Pane;
    private javax.swing.JPanel col2Pane;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_ou;
    private javax.swing.JLabel lbl_situacao;
    private javax.swing.JRadioButton rb_ativo;
    private javax.swing.JRadioButton rb_inativo;
    private javax.swing.JPanel rowPane;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables
}
