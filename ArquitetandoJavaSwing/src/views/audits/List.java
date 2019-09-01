/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.audits;

import controllers.AuditsController;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import sources.Audit;

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

        ArrayList<Audit> audits = new AuditsController().list();
        setTableData(tableData(audits), tableHeader());
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
        String[] header = {"Usuário", "Ação", "Dados", "Data"};

        return header;
    }

    private Object[][] tableData(ArrayList<Audit> audits) {
        int row = 0;
        Object[][] data = new Object[audits.size()][4];

        for (Audit audit : audits) {
            data[row][0] = audit.getModifiedBy();
            data[row][1] = audit.getAction();
            data[row][2] = audit.getContent();
            data[row][3] = audit.getModifiedDate();

            row++;
        }

        return data;
    }

    private void setTableConfig() {
        // não redimencionavel
        table.getTableHeader().setReorderingAllowed(false);

        // não selecionar linha
        table.setRowSelectionAllowed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();

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

        titleLabel.setText("Auditoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
