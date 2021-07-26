/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.helper;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hp
 */
public class ConectionHelper {
    private static final String DB_NAME = "toko_bangunan";
 private static final String USER = "root";
 private static final String PASSWORD = "";
 private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

public static Connection getConnection() throws SQLException{ //membuat method connection
    DriverManager.registerDriver(new Driver()); //memanggil class untuk mengelola drive
    
    //membuat koneksi supaya terhubung ke database
    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
    return connection;//mengembalikan isi dari method connection
    }
}
