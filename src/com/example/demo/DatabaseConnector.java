package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/onlineexam";
    private static final String USER = "root";
    private static final String PASS = "Sanjay123@";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
