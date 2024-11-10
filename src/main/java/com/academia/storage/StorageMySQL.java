package com.academia.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Classe para conexão com o banco de dados MySQL.
 */
public class StorageMySQL {
    private static StorageMySQL instance;
    private static Connection connection;
    private static final String URL = "jdbc:sqlite:database.db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /*
     * Construtor privado para garantir que a classe seja um singleton.
     */
    private StorageMySQL() {
    }

    /*
     * Método para obter a instância da classe.
     *
     * @return Instância da classe.
     */
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com o banco de dados.");
        }
    }

    /*
     * Sobrescreve o método toString para retornar uma descrição da classe.
     *
     * @return Descrição da classe.
     */
    @Override
    public String toString() {
        return "Classe de conexão com o banco de dados MySQL.";
    }
}