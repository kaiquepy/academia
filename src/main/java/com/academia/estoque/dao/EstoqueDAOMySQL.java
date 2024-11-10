package com.academia.estoque.dao;

import com.academia.storage.StorageMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstoqueDAOMySQL implements EstoqueDAO {
    @Override
    public void adicionarEstoque(int produtoId, int quantidade) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO estoque (produto_id, quantidade) VALUES (?, ?) ON CONFLICT(produto_id) DO UPDATE SET quantidade = quantidade + excluded.quantidade";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produtoId);
            stmt.setInt(2, quantidade);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar estoque no MySQL", e);
        }
    }

    @Override
    public void atualizarEstoque(int produtoId, int quantidade) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "UPDATE estoque SET quantidade = ? WHERE produto_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar estoque no MySQL", e);
        }
    }

    @Override
    public void removerEstoque(int produtoId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM estoque WHERE produto_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produtoId);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover estoque no MySQL", e);
        }
    }

    @Override
    public int buscarQuantidadePorProdutoId(int produtoId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT quantidade FROM estoque WHERE produto_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produtoId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantidade");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar quantidade no estoque do MySQL", e);
        }
        return 0;
    }
}
