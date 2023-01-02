/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

import koneksi.Database;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author WINDOWS 10
 */
public class Cart {

    int idTransaksi;
    Customer customer = new Customer();
    Product barang = new Product();
    int total, jumlah, hargaBarang;

    public Cart() {

    }

    public Cart(int idTransaksi, Customer customer, Product barang, int total, int jumlah, int hargaBarang) {
        this.idTransaksi = idTransaksi;
        this.customer = customer;
        this.barang = barang;
        this.total = total;
        this.jumlah = jumlah;
        this.hargaBarang = hargaBarang;

    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public int getTotal() {
        return total;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBarang(Product barang) {
        this.barang = barang;
    }

    public Product getBarang() {
        return barang;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cart getById(int id) {
//        Transaksi tr = new Transaksi();
//        ResultSet rs = Database.executeQuery("SELECT"
//                + "b.idTransaksi AS idTransaksi"
//                + "b." );
        Cart tr = new Cart();
        ResultSet rs = Database.selectQuery("SELECT * FROM transaksi WHERE idTransaksi = '" + id + "'");

        try {
            while (rs.next()) {
                Customer cs = new Customer();
                Product pd = new Product();
                cs.setId(rs.getInt("idCustomer"));
                cs.setNama(rs.getString("namaCust"));
                pd.setIdBarang(rs.getInt("idBarang"));
                pd.setNamaBarang(rs.getString("namaBarang"));
                tr.setIdTransaksi(rs.getInt("idTransaksi"));
                tr.setCustomer(cs);
                tr.setJumlah(rs.getInt("jumlahBarang"));
                tr.setTotal(rs.getInt("subTotal"));
                tr.setHargaBarang(rs.getInt("hargaBarang"));
                tr.setBarang(pd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tr;
    }

    public ArrayList<Cart> getAll() {
        ArrayList<Cart> ListCart = new ArrayList();
        ResultSet rs = Database.selectQuery("SELECT cart.*,customer.namaCust FROM cart JOIN customer on cart.idCustomer= customer.idCust");
        try {
            while (rs.next()) {
                Cart tr = new Cart();
                Customer cs = new Customer();
                Product pd = new Product();
                cs.setId(rs.getInt("idCustomer"));
                cs.setNama(rs.getString("namaCust"));
                pd.setIdBarang(rs.getInt("idBarang"));
                pd.setNamaBarang(rs.getString("namaBarang"));
                tr.setIdTransaksi(rs.getInt("idTransaksi"));
                tr.setCustomer(cs);
                tr.setJumlah(rs.getInt("jumlahBarang"));
                tr.setTotal(rs.getInt("subTotal"));
                tr.setHargaBarang(rs.getInt("hargaBarang"));
                tr.setBarang(pd);
                ListCart.add(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListCart;
    }

    public void save() {
        if (getById(idTransaksi).getIdTransaksi() == 0) {
            String sql = "INSERT INTO cart (idCustomer, idBarang,namaBarang,hargaBarang,jumlahBarang,subTotal) VALUES(" + " "
                    + "'" + this.getCustomer().getId() + "', "
                    + "'" + this.barang.getIdBarang() + "', "
                    + "'" + this.barang.getNamaBarang() + "', "
                    + "'" + this.barang.getHarga() + "', "
                    + "'" + this.getJumlah() + "', "
                    + "'" + this.getTotal() + "' )";
            this.idTransaksi = Database.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE cart SET "
                    + "idBarang = '" + this.barang.getIdBarang()
                    + "namaBarang = '" + this.barang.getNamaBarang()
                    + "hargaBarang = '" + this.barang.getHarga() 
                    + "jumlahBarang = '" + this.getJumlah() 
                    + "subTotal = '" + this.getTotal()
                    + "' WHERE idCust = '" + this.idTransaksi + "'";
            Database.executeQuery(sql);
        }
    }
}
