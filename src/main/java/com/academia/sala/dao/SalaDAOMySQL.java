package com.academia.sala.dao;

import com.academia.sala.model.Sala;
import com.academia.storage.StorageMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados (DAO) para Sala em MySQL.
 */
public class SalaDAOMySQL implements SalaDAO {
    /**
     * Método para adicionar uma sala.
     *
     * @param sala Sala a ser adicionada.
     */
    @Override
    public void adicionarSala(Sala sala) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO salas (nome, capacidade) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.executeUpdate();
            System.out.println("Sala salva no MySQL: " + sala.getNome());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar sala no MySQL", e);
        }
    }

    /**
     * Método para remover uma sala por ID.
     *
     * @param id ID da sala a ser removida.
     * @return boolean true se a sala foi removida, false caso contrário.
     */
    @Override
    public boolean removerSala(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM salas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover sala no MySQL", e);
        }
    }

    /**
     * Método para atualizar os dados de uma sala.
     *
     * @param sala Sala a ser atualizada.
     * @return boolean true se a sala foi atualizada, false caso contrário.
     */
    @Override
    public boolean atualizarSala(Sala sala) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "UPDATE salas SET nome = ?, capacidade = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sala.getNome());
            stmt.setInt(2, sala.getCapacidade());
            stmt.setInt(3, sala.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar sala no MySQL", e);
        }
    }

    /**
     * Método para buscar uma sala por ID.
     *
     * @param id ID da sala a ser buscada.
     * @return Sala encontrada.
     */
    @Override
    public Sala buscarSalaPorId(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM salas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Sala(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("capacidade")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar sala no MySQL", e);
        }
        return null;
    }

    /**
     * Método para listar todas as salas.
     *
     * @return Lista de salas.
     */
    @Override
    public List<Sala> listarSalas() {
        List<Sala > salas = new ArrayList<>();
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM salas";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("capacidade")
                );
                salas.add(sala);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar salas no MySQL", e);
        }
        return salas;
    }

    /**
     * Sobrescrita do método toString para retornar uma descrição da classe.
     *
     * @return String Descrição da classe.
     */
    @Override
    public String toString() {
        return "Dao (Data Access Object) de Sala em MySQL";
    }
}
