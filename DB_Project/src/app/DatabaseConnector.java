/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class DatabaseConnector
{
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public DatabaseConnector() {
        this.url = "jdbc:mysql://localhost:3306/test";
        this.username = "root";
        this.password = "root";
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    
}
