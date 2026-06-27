/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Korisnik
 */
public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("MySQL JDBC Driver not found", e);
            }

            String url = "jdbc:mysql://localhost:3306/sudoku";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }
        return connection;
    }
}
