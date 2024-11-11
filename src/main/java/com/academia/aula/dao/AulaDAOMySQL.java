package com.academia.aula.dao;

import com.academia.aula.model.Aula;
import com.academia.funcionario.model.Funcionario;
import com.academia.sala.model.Sala;
import com.academia.storage.StorageMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados (DAO) para Aula em MySQL.
 */
public class AulaDAOMySQL implements AulaDAO {
    /**
     * Adiciona uma nova aula.
     *
     * @param aula Aula a ser adicionada.
     */
    @Override
    public void adicionarAula(Aula aula) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO aulas (id, nome, sala_id, data_hora, valor, professor_id, quantidade_alunos) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aula.getId());
            stmt.setString(2, aula.getNome());
            stmt.setInt(3, aula.getSala().getId());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(aula.getDataHora()));
            stmt.setDouble(5, aula.getValor());
            stmt.setInt(6, aula.getProfessor().getId());
            stmt.setInt(7, aula.getQuantidadeAlunos());
            stmt.executeUpdate();
            System.out.println("Aula salva no MySQL: " + aula.getNome());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar aula no MySQL", e);
        }
    }

    /**
     * Remove uma aula pelo ID.
     *
     * @param aulaId Identificador da aula.
     */
    @Override
    public void removerAula(int aulaId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM aulas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aulaId);
            stmt.executeUpdate();
            System.out.println("Aula deletada do MySQL com ID: " + aulaId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover aula do MySQL", e);
        }
    }

    /**
     * Atualiza os dados de uma aula.
     *
     * @param aula Aula a ser atualizada.
     */
    @Override
    public void atualizarAula(Aula aula) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "UPDATE aulas SET nome = ?, sala_id = ?, data_hora = ?, valor = ?, professor_id = ?, quantidade_alunos = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aula.getNome());
            stmt.setInt(2, aula.getSala().getId());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(aula.getDataHora()));
            stmt.setDouble(4, aula.getValor());
            stmt.setInt(5, aula.getProfessor().getId());
            stmt.setInt(6, aula.getQuantidadeAlunos());
            stmt.setInt(7, aula.getId());
            stmt.executeUpdate();
            System.out.println("Aula atualizada no MySQL com ID: " + aula.getId());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar aula no MySQL", e);
        }
    }

    /**
     * Busca uma aula pelo ID.
     *
     * @param aulaId Identificador da aula.
     * @return Aula ou null se não encontrado.
     */
    @Override
    public Aula buscarAulaPorId(int aulaId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM aulas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aulaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Sala sala = new Sala(rs.getInt("sala_id"), "", rs.getInt("capacidade")); // Simplificação para exemplo
                Funcionario professor = new Funcionario(rs.getInt("professor_id"), "", "", 0); // Simplificação para exemplo
                return new Aula(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        sala,
                        rs.getString("data_hora"),
                        rs.getDouble("valor"),
                        professor
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar aula no MySQL", e);
        }
        return null;
    }

    /**
     * Lista todas as aulas cadastradas.
     *
     * @return Lista de aulas.
     */
    @Override
    public List<Aula> listarAulas() {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM aulas";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Aula> aulas = new ArrayList<>();
            while (rs.next()) {
                Sala sala = new Sala(rs.getInt("sala_id"), "", rs.getInt("capacidade")); // Simplificação para exemplo
                Funcionario professor = new Funcionario(rs.getInt("professor_id"), "", "", 0); // Simplificação para exemplo
                Aula aula = new Aula(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        sala,
                        rs.getString("data_hora"),
                        rs.getDouble("valor"),
                        professor
                );
                aula.setQuantidadeAlunos(rs.getInt("quantidade_alunos"));
                aulas.add(aula);
            }
            return aulas;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar aulas do MySQL", e);
        }
    }

    /**
     * Retorna a representação em String do objeto.
     *
     * @return String representando o objeto.
     */
    @Override
    public String toString() {
        return "Dao (Data Access Object) de Aula em MySQL";
    }
}