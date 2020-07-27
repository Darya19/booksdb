package com.epam.day8.model.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/archive";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}
