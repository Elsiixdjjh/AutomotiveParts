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
 * @author HP
 */
public class Cashier extends AbstractUser implements InterfaceSetting{
    String password;
    
    public Cashier(){
        
    }
    
    public Cashier(String nama, String password){
        this.nama = nama;
        this.password = password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public Cashier getById(int id){
        Cashier cash = new Cashier();
        ResultSet rs = Database.selectQuery("SELECT * FROM kasir " + " WHERE idKasir = '" + id + "' ");
        try{
            while(rs.next()){
                cash = new Cashier();
                cash.setId(rs.getInt("idKasir"));
                cash.setNama(rs.getString("namaKasir"));
                cash.setPassword(rs.getString("passwordKasir"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cash;
    }
    public ArrayList<Cashier>getAll(){
        ArrayList listCashier = new ArrayList();
        ResultSet rs = Database.selectQuery("SELECT * FROM kasir ");
        try{
            while(rs.next()){
                Cashier cash = new Cashier();
                cash.setId(rs.getInt("idKasir"));
                cash.setNama(rs.getString("namaKasir"));
                cash.setPassword(rs.getString("passwordKasir"));
                
                listCashier.add(cash);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listCashier;
    }
    
    public ArrayList<Cashier>search(String keyword){
        ArrayList<Cashier> listCashier = new ArrayList();
        String sql = "SELECT * FROM kasir WHERE " + " namaKasir LIKE '%" + keyword + "%' ";
        ResultSet rs = Database.selectQuery(sql);
        
        try{
            while(rs.next()){
                Cashier cash = new Cashier();
                cash.setId(rs.getInt("idKasir"));
                cash.setNama(rs.getString("namaKasir"));
                cash.setPassword(rs.getString("passwordKasir"));
                
                listCashier.add(cash);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listCashier;
    }
    
    public void save(){
        if(getById(id).getId() == 0){
            String sql = "INSERT INTO kasir (namaKasir, passwordKasir) VALUES (" + " '" + this.nama + "', '" + this.password + "' )";
            this.id = Database.insertQueryGetId(sql);
        }else{
            String sql = "UPDATE kasir SET namaKasir = '" + this.nama + "', passwordKasir = '" + this.password + "' WHERE idKasir = '" + this.id + "'";
            Database.executeQuery(sql);
        }
    }
    
    public void delete(){
        String sql = "DELETE FROM kasir WHERE idKasir = '" + this.id + "'";
        Database.executeQuery(sql);
    }
    
    @Override
    public String toString(){
        return nama;
    }
}
