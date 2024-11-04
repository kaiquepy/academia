package com.academia.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StorageMySQL {
    private static StorageMySQL instance;
    private static Connection connection;
    private static final String URL = "jdbc:sqlite:database.db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private StorageMySQL() {
    }

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com o banco de dados.");
        }
    }
}