/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.categorias;

import controllers.CategoriasController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sources.Category;
import views.main.ApplicationView;

/**
 *
 * @author nyko-
 */
public class CategoriasListagem extends javax.swing.JInternalFrame {

    /**
     * Creates new form CategoriasListagem
     */
    public CategoriasListagem() {
        initComponents();
        configurarPesquisa();
        
        ArrayList<Category> categorias = new CategoriasController().listar(parametrosPesquisa());
        popularTabela(tableData(categorias), tableHeader());
    }
    
    private void configurarPesquisa() {
        cb_pesquisaStatus.removeAllItems();
        cb_pesquisaStatus.addItem("Todos");
        cb_pesquisaStatus.addItem("Ativos");
        cb_pesquisaStatus.addItem("Inativos");
        cb_pesquisaStatus.setSelectedIndex(1);
    }
    
    private void popularTabela(Object[][] tableData, String[] tableHeader) {
        table.setModel(new DefaultTableModel(tableData, tableHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // coluna não editavel
                return false;
            }
        });
        
        cofigurarTabela();
    }
    
    private String[] tableHeader() {
        String[] header = { "ID", "Nome", "", "" };
        
        return header;
    }
    
    private Object[][] tableData(ArrayList<Category> categorias) {
        int row = 0;
        Object[][] data = new Object[categorias.size()][5];

        for (Object object : categorias) {
            Category categoria = (Category) object;

            data[row][0] = categoria.getId();
            data[row][1] = categoria.getName();
            
            if (categoria.isInativo() && cb_pesquisaStatus.getSelectedItem() != "Inativos") {
                data[row][1] += " - INATIVO";
            }
            
            data[row][2] = new ImageIcon(getClass().getResource("/images/pencil.png"));
            data[row][3] = new ImageIcon(getClass().getResource("/images/times.png"));

            row++;
        }

        return data;
    }
    
    private void cofigurarTabela() {
        definirLarguraColunas();

        // não redimencionavel
        table.getTableHeader().setReorderingAllowed(false);

        // não selecionar linha
        table.setRowSelectionAllowed(false);

        // definir conteudo como img
         table.getColumnModel().getColumn(2).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));
         table.getColumnModel().getColumn(3).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));

        definirClickNasColunas();
    }
    
    private void definirLarguraColunas() {
        table.getColumnModel().getColumn(0).setWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        
        table.getColumnModel().getColumn(2).setWidth(20);
        table.getColumnModel().getColumn(2).setMinWidth(20);
        table.getColumnModel().getColumn(2).setMaxWidth(20);
        
        table.getColumnModel().getColumn(3).setWidth(20);
        table.getColumnModel().getColumn(3).setMinWidth(20);
        table.getColumnModel().getColumn(3).setMaxWidth(20);
    }
    
    private void definirClickNasColunas() {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());

                if (row >= 0 && col == 2) {
                    int id = (int) table.getModel().getValueAt(row, 0);

                    CategoriasAtualizar frame = new CategoriasAtualizar(id);
                    ApplicationView.changeInternalFrame(frame);
                } else if (row >= 0 && col == 3) {
                    int id = (int) table.getModel().getValueAt(row, 0);

                    excluirCategoria(id);
                }
            }
        });
    }
    
    private void excluirCategoria(int id) {
        Category categoria = new CategoriasController().procurar(id);

        if (categoria != null) {
            String pergunta = "Você tem certeza de que dezeja excluir a categoria '" + categoria.getName() + "'?";

            int dialogResult = JOptionPane.showConfirmDialog(null, pergunta, "Arquitetando", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                String errors = new CategoriasController().excluir(id);

                if (errors == null || errors.isEmpty()) {
                    btn_submit.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, errors);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Houve um problema ao exlcuir pois essa categoria não foi encontrado no banco de dados.");
        }
    }
    
    private String parametrosPesquisa() {
        String nome = tf_pesquisaNome.getText();
        String status = (String) cb_pesquisaStatus.getSelectedItem();
        
        String params = "{nome: \"%[nome]%\", status: \"%[status]%\"}";
        
        params = params.replaceAll("%[nome]%", nome);
        params = params.replaceAll("%[status]%", status);

        return params;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_new = new javax.swing.JButton();
        painelPesquisa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_pesquisaNome = new javax.swing.JTextField();
        btn_submit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cb_pesquisaStatus = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        btn_new.setText("Adicionar");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        painelPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        jLabel1.setText("Nome:");

        tf_pesquisaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_pesquisaNomeKeyPressed(evt);
            }
        });

        btn_submit.setText("Pesquisar");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        jLabel4.setText("Situação:");

        cb_pesquisaStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout painelPesquisaLayout = new javax.swing.GroupLayout(painelPesquisa);
        painelPesquisa.setLayout(painelPesquisaLayout);
        painelPesquisaLayout.setHorizontalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_pesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addComponent(cb_pesquisaStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_submit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPesquisaLayout.setVerticalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_pesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_submit)
                    .addComponent(cb_pesquisaStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_new))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_new)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        CategoriasAdicionar frame = new CategoriasAdicionar();
        ApplicationView.changeInternalFrame(frame);
    }//GEN-LAST:event_btn_newActionPerformed

    private void tf_pesquisaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesquisaNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_submit.doClick();
        }
    }//GEN-LAST:event_tf_pesquisaNomeKeyPressed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        ArrayList<Category> categorias = new CategoriasController().listar(parametrosPesquisa());
        
        Object[][] tableData = tableData(categorias);
        
        popularTabela(tableData, tableHeader());
    }//GEN-LAST:event_btn_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> cb_pesquisaStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf_pesquisaNome;
    // End of variables declaration//GEN-END:variables

    
}
