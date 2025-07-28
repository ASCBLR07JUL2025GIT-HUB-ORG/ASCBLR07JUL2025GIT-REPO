package com.demo.jdbc.my_sql;

import java.sql.*;

public class JDBCSelectStatement {
    public static void main(String[] args) {
// The Connection interface provides methods for connecting to a database, creating statements, and managing transactions.
// The DriverManager class manages a list of database drivers and establishes connections to databases.
// The Statement interface is used to execute SQL statements against a database.
        Connection connection = null;
        try {
            // Load SQL Server JDBC driver
            // The class Class is used to load the JDBC driver class dynamically.
            // We dynmacally load the driver because it allows us to use the driver without hardcoding it in the code.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded!");

            // Use Windows Authentication
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;integratedSecurity=true;";
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;user=sa;password=sqlserver;";
            String url = "jdbc:mysql://localhost:3306/testdb?user=root&password=mysql";

// DriverManager.getConnection() method is used to establish a connection to the database using the provided URL, username, and password.
            connection = DriverManager.getConnection(url);
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb", "root", "mysql");
            System.out.println("Connection established!");

            Statement statement = connection.createStatement();
            System.out.println("Statement created");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users ORDER BY user_id");
            System.out.println("Result set returned");

            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("user_id"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Last Name: " + resultSet.getString("last_name"));
                System.out.println("********");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
