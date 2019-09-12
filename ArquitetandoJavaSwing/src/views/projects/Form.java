/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.projects;

import forms.ProjectForm;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import resources.NumberParse;
import sources.ProjectMaterial;

/**
 *
 * @author nyko-
 */
public class Form extends javax.swing.JInternalFrame {

    private final ProjectForm form;

    /**
     * Creates new form Form
     *
     * @param id
     */
    public Form(final int id) {
        form = new ProjectForm(id);

        initComponents();

        initComponents();

        titleLabel.setText("Alterar Projeto");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

        initFields();
    }

    public Form() {
        form = new ProjectForm();

        initComponents();

        titleLabel.setText("Adicionar Projeto");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

        initFields();
    }

    private void initFields() {
        this.nameTextField.setText(form.getName());

        slabLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        wallLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        slabThermalTransmittanceValueLabel.setText(form.getSlabThermalTransmittance());
        wallThermalTransmittanceValueLabel.setText(form.getWallThermalTransmittance());

        slabThermalTransmittanceValueLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        wallThermalTransmittanceValueLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

        buildSlabMaterialsTable();
        buildWallMaterialsTable();
    }

    private void buildSlabMaterialsTable() {
        setTableData(slabMaterialTable, tableData(form.getSlabMaterials()), tableHeader());
    }

    private void buildWallMaterialsTable() {
        setTableData(wallMaterialTable, tableData(form.getWallMaterials()), tableHeader());
    }

    private void setTableData(JTable table, Object[][] tableData, String[] tableHeader) {
        table.setModel(new DefaultTableModel(tableData, tableHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // coluna não editavel
                return false;
            }
        });

        setTableConfig(table);
    }

    private String[] tableHeader() {
        String[] header = {
            "Material",
            "Indice de Condutividade Termica",
            "Largura (m)",
            "Resistência térmica",
            "",
            ""
        };

        return header;
    }

    private Object[][] tableData(ArrayList<ProjectMaterial> projectMaterials) {
        int row = 0;
        Object[][] data = new Object[projectMaterials.size()][6];

        for (Object object : projectMaterials) {
            ProjectMaterial projectMaterial = (ProjectMaterial) object;

            data[row][0] = projectMaterial.getMaterial().getName();
            data[row][1] = projectMaterial.getMaterial().getThermalConductivityIndex();
            data[row][2] = projectMaterial.getWidth();
            data[row][3] = NumberParse.localizeFromDouble(projectMaterial.getThermalConductivity(), "####0,00000");

            data[row][4] = new ImageIcon(getClass().getResource("/images/pencil.png"));
            data[row][5] = new ImageIcon(getClass().getResource("/images/times.png"));

            row++;
        }

        return data;
    }

    private void setTableConfig(JTable table) {
        // não redimencionavel
        table.getTableHeader().setReorderingAllowed(false);

        // não selecionar linha
        table.setRowSelectionAllowed(false);

        // definir conteudo como img
        table.getColumnModel().getColumn(4).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));
        table.getColumnModel().getColumn(5).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));

        setTableColumnsWidth(table);
        setTableColumnAction(table);
    }

    private void setTableColumnsWidth(JTable table) {
        table.getColumnModel().getColumn(4).setWidth(20);
        table.getColumnModel().getColumn(4).setMinWidth(20);
        table.getColumnModel().getColumn(4).setMaxWidth(20);

        table.getColumnModel().getColumn(5).setWidth(20);
        table.getColumnModel().getColumn(5).setMinWidth(20);
        table.getColumnModel().getColumn(5).setMaxWidth(20);
    }

    private void setTableColumnAction(JTable table) {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());

//                if (row >= 0 && col == 4) {
//                    Item item = items.get(row);
//                    new ItemModal().edit(item);
//                    items.set(row, item);
//                } else if (row >= 0 && col == 5) {
//                    items.remove(row);
//                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        slabMaterialTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        slabLabel = new javax.swing.JLabel();
        addSlabMaterialButton = new javax.swing.JButton();
        wallLabel = new javax.swing.JLabel();
        addWallMaterialButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        wallMaterialTable = new javax.swing.JTable();
        submitButton = new javax.swing.JButton();
        orLabel = new javax.swing.JLabel();
        cancellButton = new javax.swing.JButton();
        slabThermalTransmittanceLabel = new javax.swing.JLabel();
        slabThermalTransmittanceValueLabel = new javax.swing.JLabel();
        wallThermalTransmittanceLabel = new javax.swing.JLabel();
        wallThermalTransmittanceValueLabel = new javax.swing.JLabel();

        backButton.setText("Voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        slabMaterialTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(slabMaterialTable);

        titleLabel.setText("Adicionar/Alterar Projeto");

        nameLabel.setText("* Nome:");

        slabLabel.setText("Laje");

        addSlabMaterialButton.setText("Adicionar");
        addSlabMaterialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSlabMaterialButtonActionPerformed(evt);
            }
        });

        wallLabel.setText("Parede");

        addWallMaterialButton.setText("Adicionar");
        addWallMaterialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWallMaterialButtonActionPerformed(evt);
            }
        });

        wallMaterialTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(wallMaterialTable);

        submitButton.setText("Gravar");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        orLabel.setText("ou");

        cancellButton.setText("Cancelar");
        cancellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellButtonActionPerformed(evt);
            }
        });

        slabThermalTransmittanceLabel.setText("Transmitância Térmica:");

        slabThermalTransmittanceValueLabel.setText("0,00");

        wallThermalTransmittanceLabel.setText("Transmitância Térmica:");

        wallThermalTransmittanceValueLabel.setText("0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slabLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addSlabMaterialButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wallLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addWallMaterialButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancellButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(slabThermalTransmittanceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slabThermalTransmittanceValueLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(wallThermalTransmittanceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wallThermalTransmittanceValueLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(titleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slabLabel)
                    .addComponent(addSlabMaterialButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slabThermalTransmittanceLabel)
                    .addComponent(slabThermalTransmittanceValueLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWallMaterialButton)
                    .addComponent(wallLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wallThermalTransmittanceLabel)
                    .addComponent(wallThermalTransmittanceValueLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(orLabel)
                    .addComponent(cancellButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        form.cancel();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addSlabMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSlabMaterialButtonActionPerformed
        form.slabAddMaterial();
        slabThermalTransmittanceValueLabel.setText(form.getSlabThermalTransmittance());
        buildSlabMaterialsTable();
    }//GEN-LAST:event_addSlabMaterialButtonActionPerformed

    private void addWallMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWallMaterialButtonActionPerformed
        form.wallAddMaterial();
        wallThermalTransmittanceValueLabel.setText(form.getWallThermalTransmittance());
        buildWallMaterialsTable();
    }//GEN-LAST:event_addWallMaterialButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String name = nameTextField.getText();

        form.save(name);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellButtonActionPerformed
        form.cancel();
    }//GEN-LAST:event_cancellButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSlabMaterialButton;
    private javax.swing.JButton addWallMaterialButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancellButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel orLabel;
    private javax.swing.JLabel slabLabel;
    private javax.swing.JTable slabMaterialTable;
    private javax.swing.JLabel slabThermalTransmittanceLabel;
    private javax.swing.JLabel slabThermalTransmittanceValueLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel wallLabel;
    private javax.swing.JTable wallMaterialTable;
    private javax.swing.JLabel wallThermalTransmittanceLabel;
    private javax.swing.JLabel wallThermalTransmittanceValueLabel;
    // End of variables declaration//GEN-END:variables

}
