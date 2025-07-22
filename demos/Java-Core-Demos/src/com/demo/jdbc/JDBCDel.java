package com.demo.jdbc;

public class JDBCDel {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
