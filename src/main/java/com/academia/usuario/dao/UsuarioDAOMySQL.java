package com.academia.usuario.dao;

import com.academia.storage.StorageMySQL;
import com.academia.usuario.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOMySQL implements UsuarioDAO {
    @Override
    public void adicionarUsuario(Usuario usuario) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
            System.out.println("Usuário adicionado com sucesso no MySQL.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar usuário no MySQL", e);
        }
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso no MySQL.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário no MySQL", e);
        }
    }

    @Override
    public void removerUsuario(int usuarioId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            stmt.executeUpdate();
            System.out.println("Usuário removido com sucesso no MySQL.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover usuário no MySQL", e);
        }
    }

    @Override
    public Usuario buscarUsuarioPorId(int usuarioId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por ID no MySQL", e);
        }
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por email no MySQL", e);
        }
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM usuarios";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários no MySQL", e);
        }
        return usuarios;
    }
}