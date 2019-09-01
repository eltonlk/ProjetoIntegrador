/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.materials;

import controllers.MaterialsController;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import resources.NumberParse;
import sources.Material;
import views.main.ApplicationView;

/**
 *
 * @author nyko-
 */
public class List extends javax.swing.JInternalFrame {

    /**
     * Creates new form List
     */
    public List() {
        initComponents();
        
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        
        initSearchForm();

        ArrayList<Material> materials = new MaterialsController().list(searchParams());
        setTableData(tableData(materials), tableHeader());
    }

    private void initSearchForm() {
        cb_searchStatus.removeAllItems();
        cb_searchStatus.addItem("Todos");
        cb_searchStatus.addItem("Ativos");
        cb_searchStatus.addItem("Inativos");
        cb_searchStatus.setSelectedIndex(1);
    }

    private void setTableData(Object[][] tableData, String[] tableHeader) {
        table.setModel(new DefaultTableModel(tableData, tableHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // coluna não editavel
                return false;
            }
        });

        setTableConfig();
    }

    private String[] tableHeader() {
        String[] header = {"ID", "Nome", "Indice Cond. Térmica", "Situação", "", ""};

        return header;
    }

    private Object[][] tableData(ArrayList<Material> materials) {
        int row = 0;
        Object[][] data = new Object[materials.size()][6];

        for (Object object : materials) {
            Material material = (Material) object;

            data[row][0] = material.getId();
            data[row][1] = material.getName();
            data[row][2] = NumberParse.localizeFromDouble(material.getThermalConductivityIndex(), "####0.00###");

            if (material.isInactive()) {
                data[row][3] = "Inativo";
            } else {
                data[row][3] = "Ativo";
            }

            data[row][4] = new ImageIcon(getClass().getResource("/images/pencil.png"));
            data[row][5] = new ImageIcon(getClass().getResource("/images/times.png"));

            row++;
        }

        return data;
    }

    private void setTableConfig() {
        // não redimencionavel
        table.getTableHeader().setReorderingAllowed(false);

        // não selecionar linha
        table.setRowSelectionAllowed(false);

        // definir conteudo como img
        table.getColumnModel().getColumn(4).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));
        table.getColumnModel().getColumn(5).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));

        setTableColumnsWidth();
        setTableColumnAction();
    }

    private void setTableColumnsWidth() {
        table.getColumnModel().getColumn(0).setWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);

        table.getColumnModel().getColumn(3).setWidth(80);
        table.getColumnModel().getColumn(3).setMinWidth(80);
        table.getColumnModel().getColumn(3).setMaxWidth(80);

        table.getColumnModel().getColumn(4).setWidth(20);
        table.getColumnModel().getColumn(4).setMinWidth(20);
        table.getColumnModel().getColumn(4).setMaxWidth(20);

        table.getColumnModel().getColumn(5).setWidth(20);
        table.getColumnModel().getColumn(5).setMinWidth(20);
        table.getColumnModel().getColumn(5).setMaxWidth(20);
    }

    private void setTableColumnAction() {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());

                if (row >= 0 && col == 4) {
                    int id = (int) table.getModel().getValueAt(row, 0);

                    ApplicationView.changeInternalFrame(new Form(id));
                } else if (row >= 0 && col == 5) {
                    int id = (int) table.getModel().getValueAt(row, 0);

                    destroyMaterial(id);
                }
            }
        });
    }

    private void destroyMaterial(int id) {
        Material material = new MaterialsController().find(id);

        if (material != null) {
            String pergunta = "Você tem certeza de que dezeja excluir o material '" + material.getName() + "'?";

            int dialogResult = JOptionPane.showConfirmDialog(null, pergunta, "Arquitetando", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                String errors = new MaterialsController().delete(id);

                if (errors == null || errors.isEmpty()) {
                    btn_searchSubmit.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, errors);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Houve um problema ao exlcuir pois esse material não foi encontrado no banco de dados.");
        }
    }

    private String searchParams() {
        String name = tf_searchName.getText();
        String status = (String) cb_searchStatus.getSelectedItem();

        String params = "{ \"name\":\"%[name]%\", \"status\":\"%[status]%\" }";

        params = params.replaceAll("%[name]%", name);
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
        searchPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_searchName = new javax.swing.JTextField();
        btn_searchSubmit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cb_searchStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();

        btn_new.setText("Adicionar");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        searchPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        jLabel1.setText("Nome:");

        tf_searchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_searchNameKeyPressed(evt);
            }
        });

        btn_searchSubmit.setText("Pesquisar");
        btn_searchSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchSubmitActionPerformed(evt);
            }
        });

        jLabel4.setText("Situação:");

        cb_searchStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout searchPaneLayout = new javax.swing.GroupLayout(searchPane);
        searchPane.setLayout(searchPaneLayout);
        searchPaneLayout.setHorizontalGroup(
            searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(searchPaneLayout.createSequentialGroup()
                        .addComponent(cb_searchStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_searchSubmit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchPaneLayout.setVerticalGroup(
            searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchSubmit)
                    .addComponent(cb_searchStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        titleLabel.setText("Materiais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_new))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(titleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        ApplicationView.changeInternalFrame(new Form());
    }//GEN-LAST:event_btn_newActionPerformed

    private void tf_searchNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_searchSubmit.doClick();
        }
    }//GEN-LAST:event_tf_searchNameKeyPressed

    private void btn_searchSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchSubmitActionPerformed
        ArrayList<Material> materials = new MaterialsController().list(searchParams());

        setTableData(tableData(materials), tableHeader());
    }//GEN-LAST:event_btn_searchSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_searchSubmit;
    private javax.swing.JComboBox<String> cb_searchStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel searchPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField tf_searchName;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
