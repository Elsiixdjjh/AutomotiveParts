/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;
import java.util.ArrayList;
import java.sql.*;
import koneksi.Database;
/**
 *
 * @author WINDOWS 10
 */
public class Product implements InterfaceSetting{     
    int id, harga;
    String namaBarang, kategori;
    
    public Product(){
        
    }
    
    public Product(int id, String namaBarang, String kategori,  int harga){
        this.id = id;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.harga = harga;
    }
    
    public void setIdBarang(int id){
        this.id = id;
    }
    
    public int getIdBarang(){
        return id;
    }
    
    public void setNamaBarang(String namaBarang){
        this.namaBarang = namaBarang;
    }
    
    public String getNamaBarang(){
        return namaBarang;
    }
    
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    
    public String getKategori(){
        return kategori;
    }
        
    public void setHarga(int harga){
        this.harga = harga;
    }
    
    public int getHarga(){
        return harga;
    }
    
    public Product getById(int id){
        Product pr = new Product();
        ResultSet rs = Database.selectQuery("SELECT * FROM barang WHERE idBarang = '" + id + "'");
       
        try{
            while(rs.next()){
                pr = new Product();
                pr.setIdBarang(rs.getInt("idBarang"));
                pr.setNamaBarang(rs.getString("namaBarang"));
                pr.setKategori(rs.getString("kategori"));
                pr.setHarga(rs.getInt("hargaBarang"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       
       return pr;
    }
    
    public ArrayList<Product> getAll(){
        ArrayList<Product> ListProduct = new ArrayList();
        ResultSet rs = Database.selectQuery("SELECT * FROM barang");
        try{
            while(rs.next()){
                Product pr = new Product();
                pr.setIdBarang(rs.getInt("idBarang"));
                pr.setNamaBarang(rs.getString("namaBarang"));
                pr.setKategori(rs.getString("kategori"));
                pr.setHarga(rs.getInt("hargaBarang"));
                
                ListProduct.add(pr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return ListProduct;
    }
    
    public ArrayList<Product> search(String keyword){
        ArrayList<Product> ListProduct = new ArrayList();
        String sql = "SELECT * FROM barang WHERE " + " namaBarang LIKE '%" + keyword + "%' ";
        ResultSet rs = Database.selectQuery(sql);
        
        try{
            while(rs.next()){
                Product pr = new Product();
                pr.setIdBarang(rs.getInt("idBarang"));
                pr.setNamaBarang(rs.getString("namaBarang"));
                pr.setKategori(rs.getString("kategori"));
                pr.setHarga(rs.getInt("hargaBarang"));
                
                ListProduct.add(pr);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return ListProduct;
    }
    
    public void save(){
        if(getById(id).getIdBarang() == 0){
            String sql = "INSERT INTO `barang` (`namaBarang`, `kategori`, `hargaBarang`) "
                     + "VALUES ('"+ this.namaBarang +"', '" + this.kategori + "', '" + this.harga + "')";
            this.id = Database.insertQueryGetId(sql);
        }else{
            String sql = "UPDATE barang SET namaBarang = '" + this.namaBarang + "', kategori = '" + this.kategori + "', hargaBarang = '" + this.harga + "' WHERE idBarang = '" + this.id + "'";
            Database.executeQuery(sql);
        }
    }
    
    public void delete(){
        String sql = "DELETE FROM barang WHERE idBarang = '" + this.id + "'";
        Database.executeQuery(sql);
    }
    
    @Override
    public String toString(){
        return namaBarang;
    }
}
