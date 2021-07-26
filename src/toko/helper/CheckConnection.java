/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class CheckConnection {
     public static void main(String[] args){ //membuat main method agar bisa dieksekusi
        isConnected();
        showBook();
    }
    //digunakan untuk mengecek apakah database sudah terkoneksi atau tidak
    private static boolean isConnected(){
        try{ 
            ConectionHelper.getConnection(); 
            System.out.println("Database Connected"); 
            return true; 
        } catch (SQLException ex){ 
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to connect database"); 
            return false;
        }
    }
    
   
    public static  void showBook(){
        try{  
            Connection conn = ConectionHelper.getConnection(); 
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from barang");
            
            while(rs.next()){ 
                System.out.println("ID Barang: "+rs.getString("ID_Barang")+", Nama Barang: "+rs.getString("nama_barang")
                        +", Quantity "+rs.getString("quantity")+", Harga Barang "+rs.getString("harga_barang")+", Kategori: "
                +rs.getString("kategori"));
            }   

        } catch (SQLException ex){
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null,ex);    
            }
        }
    }

