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
public class Transaksi {

    int idTransaksi;
    Customer customer = new Customer();
    Product barang = new Product();
    int total, jumlah;

    public Transaksi() {

    }

    public Transaksi(int idTransaksi, Customer customer, Product barang, int total, int jumlah) {
        this.idTransaksi = idTransaksi;
        this.customer = customer;
        this.barang = barang;
        this.total = total;
        this.jumlah = jumlah;

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

    public Transaksi getById(int id) {
        Transaksi tr = new Transaksi();
        ResultSet rs = Database.selectQuery("SELECT * FROM transaksi WHERE idTransaksi = '" + id + "'");
        
        return tr;
    }

    public ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        ResultSet rs = Database.selectQuery("SELECT transaksi.*,customer.namaCust FROM transaksi JOIN customer on transaksi.idCustomer= customer.idCust");
        try {
            while (rs.next()) {
                Transaksi tr = new Transaksi();
                Customer cs = new Customer();
                Product pd = new Product();
                cs.setId(rs.getInt("idCustomer"));
                cs.setNama(rs.getString("namaCust"));
                pd.setIdBarang(rs.getInt("idBarang"));
                pd.setNamaBarang(rs.getString("namaBarang"));
                tr.setIdTransaksi(rs.getInt("idTransaksi"));
                tr.setCustomer(cs);
                tr.setJumlah(rs.getInt("jumlahBarang"));
                tr.setTotal(rs.getInt("totalHarga"));
                tr.setBarang(pd);
                ListTransaksi.add(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListTransaksi;
    }

    public void save(String id) {
        String sql = "INSERT INTO  transaksi (idCustomer,idBarang,namaBarang,jumlahBarang,totalHarga) "
                + "SELECT cart.idCustomer,cart.idBarang,cart.namaBarang,cart.jumlahBarang,cart.subTotal as totalHarga  "
                + "FROM cart  "
                + "WHERE cart.idTransaksi = "+id+";";
        this.idTransaksi = Database.insertQueryGetId(sql);
        String sql2 = "DELETE FROM cart WHERE idTransaksi = "+id+";";
        Database.executeQuery(sql2);
    }
    
    public void delete(String id) {
        String sql2 = "DELETE FROM transaksi WHERE idTransaksi = "+id+";";
        Database.executeQuery(sql2);
    }
}
