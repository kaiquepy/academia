package com.academia.funcionario.dao;

import com.academia.funcionario.model.Funcionario;
import com.academia.storage.StorageMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAOMySQL implements FuncionarioDAO {
    /**
     * Adiciona um novo funcionário.
     *
     * @param funcionario Funcionário a ser adicionado.
     */
    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO funcionarios (nome, cargo, salario) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.executeUpdate();
            System.out.println("Funcionário salvo no MySQL: " + funcionario.getNome());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar funcionário no MySQL", e);
        }
    }

    /**
     * Remove um funcionário pelo ID.
     *
     * @param id Identificador do funcionário.
     */
    @Override
    public void removerFuncionario(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM funcionarios WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Funcionário deletado do MySQL com ID: " + id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover funcionário do MySQL", e);
        }
    }

    /**
     * Atualiza os dados de um funcionário.
     *
     * @param funcionario Funcionário a ser atualizado.
     */
    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "UPDATE funcionarios SET nome = ?, cargo = ?, salario = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setInt(4, funcionario.getId());
            stmt.executeUpdate();
            System.out.println("Funcionário atualizado no MySQL com ID: " + funcionario.getId());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar funcionário no MySQL", e);
        }
    }

    /**
     * Busca um funcionário pelo ID.
     *
     * @param id Identificador do funcionário.
     * @return Funcionario
     */
    @Override
    public Funcionario buscarFuncionarioPorID(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM funcionarios WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getDouble("salario")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar funcionário no MySQL", e);
        }
        return null;
    }

    /**
     * Lista todos os funcionários cadastrados.
     *
     * @return ArrayList<Funcionario>
     */
    @Override
    public ArrayList<Funcionario> listarFuncionarios() {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM funcionarios";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Funcionario> funcionarios = new ArrayList<>();
            while (rs.next()) {
                funcionarios.add(new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getDouble("salario")
                ));
            }
            return funcionarios;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar funcionários do MySQL", e);
        }
    }
}
