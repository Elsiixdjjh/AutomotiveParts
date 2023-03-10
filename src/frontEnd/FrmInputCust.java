/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontEnd;
import backEnd.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Database;
/**
 *
 * @author HP
 */
public class FrmInputCust extends javax.swing.JFrame {

    /**
     * Creates new form frmInputCust
     */
    public FrmInputCust() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }
    
    public void kosongkanForm(){
        txtCustId.setText("0");
        txtCustName.setText("");
        txtPhoneNumber.setText("");
    }
    
    public void tampilkanData(){        
        String[] coloumn = {"Customer ID", "Customer Name", "Phone Number"};
        ArrayList<Customer> list = new Customer().getAll();
        Object rowData[] = new Object[3];
        
        tblCustData.setModel(new DefaultTableModel(new Object[][] {}, coloumn));
        for(Customer cust : list){
            rowData[0] = cust.getId();
            rowData[1] = cust.getNama();
            rowData[2] = cust.getNoTelp();
            
            ((DefaultTableModel)tblCustData.getModel()).addRow(rowData);
        }
    }
    
    public void cari(String keyword){
        String[] coloumn = {"Customer ID", "Customer Name", "Phone Number"};
        ArrayList<Customer> list = new Customer().search(keyword);
        Object rowData[] = new Object[3];
        
        tblCustData.setModel(new DefaultTableModel(new Object[][] {}, coloumn));
        for(Customer cust : list){
            rowData[0] = cust.getId();
            rowData[1] = cust.getNama();
            rowData[2] = cust.getNoTelp();
            
            ((DefaultTableModel)tblCustData.getModel()).addRow(rowData);
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

        jPanel1 = new javax.swing.JPanel();
        lbCustData = new javax.swing.JLabel();
        lbCustId = new javax.swing.JLabel();
        lbCustName = new javax.swing.JLabel();
        lbPhoneNumber = new javax.swing.JLabel();
        txtCustId = new javax.swing.JTextField();
        txtCustName = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustData = new javax.swing.JTable();
        btnHome = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(164, 164, 164));

        lbCustData.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        lbCustData.setForeground(new java.awt.Color(255, 255, 255));
        lbCustData.setText("CUSTOMER DATA");

        lbCustId.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbCustId.setForeground(new java.awt.Color(255, 255, 255));
        lbCustId.setText("Customer ID");

        lbCustName.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbCustName.setForeground(new java.awt.Color(255, 255, 255));
        lbCustName.setText("Customer Name");

        lbPhoneNumber.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbPhoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        lbPhoneNumber.setText("Phone Number");

        txtCustId.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        txtCustId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustIdActionPerformed(evt);
            }
        });

        txtCustName.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N

        txtPhoneNumber.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N

        btnAdd.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tblCustData.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        tblCustData.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCustData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustData);

        btnHome.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnHome)
                            .addGap(188, 188, 188))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(lbCustData)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearch))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lbCustId)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbPhoneNumber)
                                            .addComponent(lbCustName))
                                        .addGap(22, 22, 22)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAdd)
                                    .addGap(34, 34, 34)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnDelete)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpdate)
                                    .addGap(34, 34, 34)
                                    .addComponent(btnRefresh))
                                .addComponent(txtPhoneNumber)
                                .addComponent(txtCustName)
                                .addComponent(txtCustId, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCustData)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCustId)
                    .addComponent(txtCustId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCustName)
                    .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhoneNumber)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Customer cust = new Customer();
        cust.setId(Integer.parseInt(txtCustId.getText()));
        cust.setNama(txtCustName.getText());
        cust.setNoTelp(txtPhoneNumber.getText());
        cust.save();
        txtCustId.setText(Integer.toString(cust.getId()));
        JOptionPane.showMessageDialog(null, "Customer data successfully added");
        tampilkanData();
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtCustIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustIdActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new frontEnd.FrmBeranda().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblCustData.getModel();
        int row = tblCustData.getSelectedRow();
        
        Customer cust = new Customer().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        cust.delete();
        kosongkanForm();
        JOptionPane.showMessageDialog(null, "Customer data has been successfully deleted");
        tampilkanData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblCustData.getModel();
        int row = tblCustData.getSelectedRow();
        
        String id = txtCustId.getText();
        String name = txtCustName.getText();
        String pn = txtPhoneNumber.getText();
        
        String sql = "UPDATE customer SET namaCust = '" +name+ "', noTelpCust = '" +pn+ "' WHERE idCust = '" +id+ "'";
        Database.executeQuery(sql);
        JOptionPane.showMessageDialog(null, "Customer data successfully updated");
        tampilkanData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        cari(txtSearch.getText());
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblCustDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustDataMouseClicked
        // TODO add your handl  ing code here:
        DefaultTableModel model = (DefaultTableModel)tblCustData.getModel();
        int row = tblCustData.getSelectedRow();
        
        String id = tblCustData.getValueAt(row,0).toString();
        txtCustId.setText(id);
        
        String name = tblCustData.getValueAt(row, 1).toString();
        txtCustName.setText(name);
        
        String pn = tblCustData.getValueAt(row, 2).toString();
        txtPhoneNumber.setText(pn);
    }//GEN-LAST:event_tblCustDataMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInputCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInputCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInputCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInputCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInputCust().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCustData;
    private javax.swing.JLabel lbCustId;
    private javax.swing.JLabel lbCustName;
    private javax.swing.JLabel lbPhoneNumber;
    private javax.swing.JTable tblCustData;
    private javax.swing.JTextField txtCustId;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
