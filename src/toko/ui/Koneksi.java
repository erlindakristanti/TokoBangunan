/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.ui;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Hp
 */
public class Koneksi {

        
    
    Connection con;
    Statement stm;
    ResultSet rslt;
    private static Connection Koneksi;
    
    
    public static Connection getKoneksi (){
        try{
            String url = "jdbc:mysql://localhost:3306/toko_bangunan";
            String user = "root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Koneksi = DriverManager.getConnection(url,user,password);
            System.out.println("Koneksi berhasil");
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "koneksi gagal"+e.getMessage());
        } 
        return Koneksi;
}
}
        
