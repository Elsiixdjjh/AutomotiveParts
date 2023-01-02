/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontEnd;

import backEnd.Cart;
import backEnd.Customer;
import backEnd.Product;
import backEnd.Transaksi;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import koneksi.Database;

/**
 *
 * @author WINDOWS 10
 */
public class FrmTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form frmTransaksi
     */
    DefaultTableModel table = new DefaultTableModel();
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    String idCart;
    private String idTransaction;

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public FrmTransaksi() {
        initComponents();
        tampilkanData();
        tampilkanDataCart();
        kosongkanFormBarang();
    }
    
    public void kosongkanFormBarang(){
        txtInputCust.setText("");
        txtOutputCust.setText("");
        txtProductId.setText("");
        txtProductName.setText("");
        txtPrice.setText("");
        txtQty.setText("");
        txtTotal.setText("");
    }
    
    public void kosongkanFormPayment(){
        txtGrandTotal.setText("");
        txtCash.setText("");
        txtChange.setText("");
    }

    private void deleteTransaksi() {
        Transaksi tr =  new Transaksi();
        tr.delete(idTransaction);
    }

    public void tampilkanData() {
        String[] coloumn = {"Transaction ID", "Customer Name", "Customer Name", "Product Id", "Product Name", "QTY", "Total Price"};
        ArrayList<Transaksi> list = new Transaksi().getAll();
        Object rowData[] = new Object[7];

        tblTransaction.setModel(new DefaultTableModel(new Object[][]{}, coloumn));
        for (Transaksi tr : list) {
            rowData[0] = tr.getIdTransaksi();
            rowData[1] = tr.getCustomer().getId();
            rowData[2] = tr.getCustomer().getNama();
            rowData[3] = tr.getBarang().getIdBarang();
            rowData[4] = tr.getBarang().getNamaBarang();
            rowData[5] = tr.getJumlah();
            rowData[6] = tr.getTotal();

            ((DefaultTableModel) tblTransaction.getModel()).addRow(rowData);
        }
    }

    public void tampilkanDataCart() {
        String[] coloumn = {"Cart ID", "Customer Name", "Customer Name", "Product Id", "Product Name", "QTY", "Price", "Total Price"};
        ArrayList<Cart> list = new Cart().getAll();
        Object rowData[] = new Object[8];

        tblInventory.setModel(new DefaultTableModel(new Object[][]{}, coloumn));
        for (Cart cr : list) {
            rowData[0] = cr.getIdTransaksi();
            rowData[1] = cr.getCustomer().getId();
            rowData[2] = cr.getCustomer().getNama();
            rowData[3] = cr.getBarang().getIdBarang();
            rowData[4] = cr.getBarang().getNamaBarang();
            rowData[5] = cr.getJumlah();
            rowData[6] = cr.getHargaBarang();
            rowData[7] = cr.getTotal();

            ((DefaultTableModel) tblInventory.getModel()).addRow(rowData);
        }
    }

    public void searchCustomer() {
        Customer cs = new Customer().getById(Integer.parseInt(txtInputCust.getText()));
        txtOutputCust.setText(cs.getNama());
    }

    public void searchProduct() {
        Product pd = new Product().getById(Integer.parseInt(txtProductId.getText()));
        txtProductName.setText(pd.getNamaBarang());
        txtPrice.setText(Integer.toString(pd.getHarga()));
    }

    public void addCart() {
        Cart cr = new Cart();
        Product pd = new Product().getById(Integer.parseInt(txtProductId.getText()));
        Customer cs = new Customer().getById(Integer.parseInt(txtInputCust.getText()));
        cr.setBarang(pd);
        cr.setCustomer(cs);
        cr.setJumlah(Integer.parseInt(txtQty.getText()));
        cr.setTotal(Integer.parseInt(txtTotal.getText()));
        cr.save();
        tampilkanDataCart();
    }

    public void changeTotal() {
        if (isNumeric(txtPrice.getText()) && isNumeric(txtQty.getText())) {
            txtTotal.setText(Integer.toString(Integer.parseInt(txtPrice.getText()) * Integer.parseInt(txtQty.getText())));
        }
    }

    public void changeChange() {
        if (isNumeric(txtGrandTotal.getText()) && isNumeric(txtCash.getText())) {
            txtChange.setText(Integer.toString(Integer.parseInt(txtCash.getText()) - Integer.parseInt(txtGrandTotal.getText())));
        }
    }

    public void checkout(String idCart) {
        Transaksi tr = new Transaksi();
        tr.save(idCart);
        tampilkanData();
        tampilkanDataCart();
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
        lbAutomotiveParts = new javax.swing.JLabel();
        lbCust = new javax.swing.JLabel();
        lbProductId = new javax.swing.JLabel();
        lbProductName = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbQty = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearchInventory = new javax.swing.JButton();
        lbInventory = new javax.swing.JLabel();
        btnRefreshInventory = new javax.swing.JButton();
        btnAddCart = new javax.swing.JButton();
        lbLine = new javax.swing.JLabel();
        lbTransaction = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        lbGrandTotal = new javax.swing.JLabel();
        txtGrandTotal = new javax.swing.JTextField();
        lbCash = new javax.swing.JLabel();
        txtCash = new javax.swing.JTextField();
        btnPayment = new javax.swing.JButton();
        lbChange = new javax.swing.JLabel();
        txtChange = new javax.swing.JTextField();
        btnHome = new javax.swing.JButton();
        txtInputCust = new javax.swing.JTextField();
        btnSearchCust = new javax.swing.JButton();
        txtOutputCust = new javax.swing.JTextField();
        btnSearchCust1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(100, 82, 88));

        jPanel1.setBackground(new java.awt.Color(164, 164, 164));

        lbAutomotiveParts.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        lbAutomotiveParts.setForeground(new java.awt.Color(255, 255, 255));
        lbAutomotiveParts.setText("AUTOMOTIVE PARTS");

        lbCust.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbCust.setForeground(new java.awt.Color(255, 255, 255));
        lbCust.setText("Customer ID");

        lbProductId.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbProductId.setForeground(new java.awt.Color(255, 255, 255));
        lbProductId.setText("Product ID");

        lbProductName.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbProductName.setForeground(new java.awt.Color(255, 255, 255));
        lbProductName.setText("Product Name");

        lbPrice.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(255, 255, 255));
        lbPrice.setText("Price");

        lbQty.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbQty.setForeground(new java.awt.Color(255, 255, 255));
        lbQty.setText("Qty");

        lbTotal.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(255, 255, 255));
        lbTotal.setText("Total");

        txtProductId.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N

        txtProductName.setEditable(false);
        txtProductName.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N

        txtQty.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });

        tblInventory.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "t5", "t6", "t7", "t8"
            }
        ));
        tblInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventory);

        txtSearch.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearchInventory.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnSearchInventory.setText("Search");
        btnSearchInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchInventoryActionPerformed(evt);
            }
        });

        lbInventory.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        lbInventory.setForeground(new java.awt.Color(255, 255, 255));
        lbInventory.setText("CART");

        btnRefreshInventory.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnRefreshInventory.setText("Refresh");
        btnRefreshInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshInventoryActionPerformed(evt);
            }
        });

        btnAddCart.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnAddCart.setText("Add Cart");
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });

        lbTransaction.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        lbTransaction.setForeground(new java.awt.Color(255, 255, 225));
        lbTransaction.setText("TRANSACTION");

        tblTransaction.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "transactionId", "idCustomer", "customer", "idBarang", "namaBarang", "jumlah", "totalHarga"
            }
        ));
        tblTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransactionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTransaction);

        btnDelete.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lbGrandTotal.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        lbGrandTotal.setForeground(new java.awt.Color(255, 255, 255));
        lbGrandTotal.setText("GRAND TOTAL");

        txtGrandTotal.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtGrandTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrandTotalActionPerformed(evt);
            }
        });

        lbCash.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        lbCash.setForeground(new java.awt.Color(255, 255, 255));
        lbCash.setText("CASH");

        txtCash.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtCash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCashKeyReleased(evt);
            }
        });

        btnPayment.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        btnPayment.setText("PAYMENT");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        lbChange.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        lbChange.setForeground(new java.awt.Color(255, 255, 255));
        lbChange.setText("CHANGE");

        txtChange.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        txtChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChangeActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        txtInputCust.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        txtInputCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputCustActionPerformed(evt);
            }
        });

        btnSearchCust.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnSearchCust.setText("Search");
        btnSearchCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustActionPerformed(evt);
            }
        });

        txtOutputCust.setEditable(false);
        txtOutputCust.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N

        btnSearchCust1.setFont(new java.awt.Font("SF Pro Display", 0, 12)); // NOI18N
        btnSearchCust1.setText("Search");
        btnSearchCust1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCust1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/garis.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CART");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(554, 554, 554)
                .addComponent(lbInventory)
                .addGap(340, 340, 340))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbProductId)
                                    .addComponent(lbProductName)
                                    .addComponent(lbPrice)
                                    .addComponent(lbQty)
                                    .addComponent(lbTotal)
                                    .addComponent(btnRefreshInventory))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbCust)
                                .addGap(34, 34, 34)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtInputCust)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSearchCust))
                                .addComponent(btnAddCart)
                                .addComponent(txtOutputCust, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtProductName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQty, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchCust1)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearchInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHome)
                        .addGap(238, 238, 238)
                        .addComponent(lbAutomotiveParts))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(232, 232, 232)
                                        .addComponent(lbTransaction)))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnPayment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCash, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtChange)
                                    .addComponent(txtGrandTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbGrandTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbCash, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbChange, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLine, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAutomotiveParts))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCust)
                            .addComponent(txtInputCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchCust)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbInventory)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchInventory))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtOutputCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearchCust1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbProductId)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbProductName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbQty))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefreshInventory)
                            .addComponent(btnAddCart))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lbLine, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCash)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPayment)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbChange)
                                .addGap(12, 12, 12)
                                .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbTransaction)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtInputCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputCustActionPerformed
        // TODO add your handling code here:
        Customer cust = new Customer().getById(Integer.parseInt(txtInputCust.getText()));
        if (cust.getId() == 0) {
            txtOutputCust.setText("Customer's data doesn't exist");
        } else {
            txtOutputCust.setText(cust.getNama());
        }
    }//GEN-LAST:event_txtInputCustActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new frontEnd.FrmBeranda().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChangeActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        checkout(idCart);
        kosongkanFormPayment();
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void txtGrandTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrandTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrandTotalActionPerformed

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        addCart();
        kosongkanFormBarang();
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void btnRefreshInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshInventoryActionPerformed
        kosongkanFormBarang();
    }//GEN-LAST:event_btnRefreshInventoryActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustActionPerformed
        searchCustomer();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchCustActionPerformed

    private void btnSearchCust1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCust1ActionPerformed
        searchProduct();
    }//GEN-LAST:event_btnSearchCust1ActionPerformed

    private void txtQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyPressed

    }//GEN-LAST:event_txtQtyKeyPressed

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped

    }//GEN-LAST:event_txtQtyKeyTyped

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        changeTotal();
    }//GEN-LAST:event_txtQtyKeyReleased

    private void tblInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventoryMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblInventory.getModel();
        int row = tblInventory.getSelectedRow();

        String id = tblInventory.getValueAt(row, 0).toString();
        this.idCart = id;

        String total = tblInventory.getValueAt(row, 7).toString();
        txtGrandTotal.setText(total);
    }//GEN-LAST:event_tblInventoryMouseClicked

    private void txtCashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashKeyReleased
        changeChange();
    }//GEN-LAST:event_txtCashKeyReleased

    private void tblTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransactionMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblTransaction.getModel();
        int row = tblTransaction.getSelectedRow();

        String id = tblTransaction.getValueAt(row, 0).toString();
        this.idTransaction = id;

    }//GEN-LAST:event_tblTransactionMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteTransaksi();
        tampilkanData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchInventoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchInventoryActionPerformed

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased

    }//GEN-LAST:event_txtTotalKeyReleased

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

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
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnRefreshInventory;
    private javax.swing.JButton btnSearchCust;
    private javax.swing.JButton btnSearchCust1;
    private javax.swing.JButton btnSearchInventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAutomotiveParts;
    private javax.swing.JLabel lbCash;
    private javax.swing.JLabel lbChange;
    private javax.swing.JLabel lbCust;
    private javax.swing.JLabel lbGrandTotal;
    private javax.swing.JLabel lbInventory;
    private javax.swing.JLabel lbLine;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbProductId;
    private javax.swing.JLabel lbProductName;
    private javax.swing.JLabel lbQty;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTransaction;
    private javax.swing.JTable tblInventory;
    private javax.swing.JTable tblTransaction;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtGrandTotal;
    private javax.swing.JTextField txtInputCust;
    private javax.swing.JTextField txtOutputCust;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
