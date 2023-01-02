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

public class Customer extends AbstractUser implements InterfaceSetting{
    String noTelp;
    
    public Customer(){
        
    }
    
    public Customer(String nama, String noTelp){
        this.nama = nama;
        this.noTelp = noTelp;
    }
    
    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }
    
    public String getNoTelp(){
        return noTelp;
    }
    
    public Customer getById(int id){
        Customer cust = new Customer();
        ResultSet rs = Database.selectQuery("SELECT * FROM customer " + " WHERE idCust = '" + id + "' ");
        try{
            while(rs.next()){
                cust = new Customer();
                cust.setId(rs.getInt("idCust"));
                cust.setNama(rs.getString("namaCust"));
                cust.setNoTelp(rs.getString("noTelpCust"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cust;
    }
    
    public ArrayList<Customer>getAll(){
        ArrayList listCustomer = new ArrayList();
        ResultSet rs = Database.selectQuery("SELECT * FROM customer ");
        try{
            while(rs.next()){
                Customer cust = new Customer();
                cust.setId(rs.getInt("idCust"));
                cust.setNama(rs.getString("namaCust"));
                cust.setNoTelp(rs.getString("noTelpCust"));
                
                listCustomer.add(cust);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCustomer;
    }
    
    public ArrayList<Customer>search(String keyword){
        ArrayList<Customer> listCustomer = new ArrayList();
        String sql = "SELECT * FROM customer WHERE " + " namaCust LIKE '%" + keyword + "%' ";
        ResultSet rs = Database.selectQuery(sql);
        
        try{
            while(rs.next()){
                Customer cust = new Customer();
                cust.setId(rs.getInt("idCust"));
                cust.setNama(rs.getString("namaCust"));
                cust.setNoTelp(rs.getString("noTelpCust"));
                
                listCustomer.add(cust);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listCustomer;
    }
    
    public void save(){
        if(getById(id).getId() == 0){
            String sql = "INSERT INTO customer (namaCust, noTelpCust) VALUES(" + " '" + this.nama + "', '" + this.noTelp + "' )";
            this.id = Database.insertQueryGetId(sql);
        }else{
            String sql = "UPDATE customer SET namaCust = '" + this.nama + "', noTelpCust = '" + this.noTelp + "' WHERE idCust = '" + this.id + "'";
            Database.executeQuery(sql);
        }
    }
    
    public void delete(){
        String sql = "DELETE FROM customer WHERE idCust = '" + this.id + "'";
        Database.executeQuery(sql);
    }
    
    @Override
    public String toString(){
        return nama;
    }

    public Customer getById() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
