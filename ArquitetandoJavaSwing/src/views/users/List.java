/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.users;

import controllers.UsersController;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import policies.CategoryPolicy;
import policies.UserPolicy;
import sources.User;
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
        
        btn_new.setEnabled(UserPolicy.canNew());

        loadUsers();
    }

    private void loadUsers() {
        ArrayList<User> users = new UsersController().list();
        setTableData(tableData(users), tableHeader());
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
        String[] header = {"ID", "Nome", "Login", "E-mail", "Situação", "", ""};

        return header;
    }

    private Object[][] tableData(ArrayList<User> users) {
        int row = 0;
        Object[][] data = new Object[users.size()][7];

        for (Object object : users) {
            User user = (User) object;

            data[row][0] = user.getId();
            data[row][1] = user.getName();
            data[row][2] = user.getUsername();
            data[row][3] = user.getEmail();

            if (user.isInactive()) {
                data[row][4] = "Inativo";
            } else {
                data[row][4] = "Ativo";
            }

            data[row][5] = new ImageIcon(getClass().getResource("/images/pencil.png"));
            data[row][6] = new ImageIcon(getClass().getResource("/images/times.png"));

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
        table.getColumnModel().getColumn(5).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));
        table.getColumnModel().getColumn(6).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));

        setTableColumnsWidth();
        setTableColumnAction();
    }

    private void setTableColumnsWidth() {
        table.getColumnModel().getColumn(0).setWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);

        table.getColumnModel().getColumn(4).setWidth(80);
        table.getColumnModel().getColumn(4).setMinWidth(80);
        table.getColumnModel().getColumn(4).setMaxWidth(80);

        table.getColumnModel().getColumn(5).setWidth(20);
        table.getColumnModel().getColumn(5).setMinWidth(20);
        table.getColumnModel().getColumn(5).setMaxWidth(20);

        table.getColumnModel().getColumn(6).setWidth(20);
        table.getColumnModel().getColumn(6).setMinWidth(20);
        table.getColumnModel().getColumn(6).setMaxWidth(20);
    }

    private void setTableColumnAction() {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());

                if (row >= 0 && col == 5) {
                    if (UserPolicy.canEdit()) {
                        int id = (int) table.getModel().getValueAt(row, 0);
                        
                        ApplicationView.changeInternalFrame(new views.categories.Form(id));
                    } else {
                        JOptionPane.showMessageDialog(null, "Você não tem permição para alterar os usuários.");
                    }
                } else if (row >= 0 && col == 6) {
                    if (CategoryPolicy.canEdit()) {
                        int id = (int) table.getModel().getValueAt(row, 0);
                        
                        destroyUser(id);
                    } else {
                        JOptionPane.showMessageDialog(null, "Você não tem permição para excluir os usuários.");
                    }
                }
            }
        });
    }

    private void destroyUser(int id) {
        User user = new UsersController().find(id);

        if (user != null) {
            String pergunta = "Você tem certeza de que dezeja excluir o usuário '" + user.getName() + "'?";

            int dialogResult = JOptionPane.showConfirmDialog(null, pergunta, "Arquitetando", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                String errors = new UsersController().delete(id);

                if (errors == null || errors.isEmpty()) {
                    loadUsers();
                } else {
                    JOptionPane.showMessageDialog(null, errors);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Houve um problema ao exlcuir pois esse usuário não foi encontrado no banco de dados.");
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

        btn_new = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();

        btn_new.setText("Adicionar");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

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

        titleLabel.setText("Usuários");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        ApplicationView.changeInternalFrame(new Form());
    }//GEN-LAST:event_btn_newActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_new;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
