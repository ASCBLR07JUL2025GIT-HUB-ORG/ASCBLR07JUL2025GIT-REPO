package com.demo.jdbc.ms_sql_server;

import java.sql.*;

public class JDBCInsertStatement {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Loaded!");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;user=sa;password=sqlserver;trustServerCertificate=true;";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection established!");

            Statement statement = connection.createStatement();
            System.out.println("Statement created");

            String insertQuery = "INSERT INTO Users (user_id, email, last_name) VALUES (102, 'newuser@example.com', 'Doe')";
            // The executeQuery() method is used for SELECT statements, while executeUpdate() is used for INSERT, UPDATE, DELETE statements.
            // The executeUpdate() method returns the number of rows affected by the SQL statement.
            // The executeQuery() method returns a ResultSet object for SELECT statements.

            int rowsInserted = statement.executeUpdate(insertQuery);
            System.out.println(rowsInserted + " row(s) inserted.");

        } catch (Exception exception) {
            // The printStackTrace() method prints the stack trace of the exception to the console.
            System.err.println(exception.getMessage());
            // e.printStackTrace();
            // The finally block is used to ensure that the connection is closed even if an exception occurs.
            // We always close the connection to release the resources associated with it.
            // The neceessity of closing the connection is to prevent memory leaks and ensure that the database resources are released properly.
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
