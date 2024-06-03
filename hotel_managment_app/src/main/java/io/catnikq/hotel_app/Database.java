package io.catnikq.hotel_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/java_hotel_db"; // Update with your database URL
    private static final String USER = "postgres"; // Update with your database username
    private static final String PASSWORD = "123"; // Update with your database password
    
    private Database(){
        
    };
    
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
}