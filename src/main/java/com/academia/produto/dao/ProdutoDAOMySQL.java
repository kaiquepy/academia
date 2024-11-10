package com.academia.produto.dao;

import com.academia.produto.model.Produto;
import com.academia.storage.StorageMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados (DAO) para Produto em MySQL.
 */
public class ProdutoDAOMySQL implements ProdutoDAO {
    /**
     * Método para adicionar um produto.
     *
     * @param produto Produto a ser adicionado.
     */
    @Override
    public void adicionarProduto(Produto produto) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO produtos (nome, preco, categoria) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getCategoria());
            stmt.executeUpdate();
            System.out.println("Produto salvo no MySQL: " + produto.getNome());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar produto no MySQL", e);
        }
    }

    /**
     * Método para remover um produto por ID.
     *
     * @param id ID do produto a ser removido.
     * @return boolean true se o produto foi removido, false caso contrário.
     */
    @Override
    public boolean removerProduto(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM produtos WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover produto no MySQL", e);
        }
    }

    /**
     * Método para atualizar os dados de um produto.
     *
     * @param produto Produto a ser atualizado.
     * @return boolean true se o produto foi atualizado, false caso contrário.
     */
    @Override
    public boolean atualizarProduto(Produto produto) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "UPDATE produtos SET nome = ?, preco = ?, categoria = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getCategoria());
            stmt.setInt(4, produto.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar produto no MySQL", e);
        }
    }

    /**
     * Método para buscar um produto por ID.
     *
     * @param id ID do produto a ser buscado.
     * @return Produto encontrado.
     */
    @Override
    public Produto buscarProdutoPorId(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM produtos WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("categoria")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto no MySQL", e);
        }
        return null;
    }

    /**
     * Método para listar todos os produtos.
     *
     * @return Lista de produtos.
     */
    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM produtos";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("categoria")
                );
                produtos.add(produto);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar produtos no MySQL", e);
        }
        return produtos;
    }

    /**
     * Descrição da classe.
     *
     * @return String com a descrição da classe.
     */
    @Override
    public String toString() {
        return "Dao (Data Access Object) de Produto em MySQL";
    }
}
