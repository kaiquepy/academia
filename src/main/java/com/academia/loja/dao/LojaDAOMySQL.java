package com.academia.loja.dao;

import com.academia.loja.model.Loja;
import com.academia.produto.model.Produto;
import com.academia.storage.StorageMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados (DAO) para Loja em MySQL.
 */
public class LojaDAOMySQL implements LojaDAO {
    /**
     * Método para adicionar uma loja.
     *
     * @param loja a ser adicionada.
     */
    @Override
    public void adicionarLoja(Loja loja) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO lojas (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, loja.getNome());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar loja no MySQL", e);
        }
    }

    /**
     * Atualiza os dados de uma loja.
     *
     * @param loja a ser atualizada.
     */
    @Override
    public void atualizarLoja(Loja loja) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "UPDATE lojas SET nome = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, loja.getNome());
            stmt.setInt(2, loja.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar loja no MySQL", e);
        }
    }

    /**
     * Remove uma loja por ID.
     *
     * @param lojaId ID da loja a ser removida.
     */
    @Override
    public void removerLoja(int lojaId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM lojas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lojaId);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover loja no MySQL", e);
        }
    }

    /**
     * Busca uma loja por ID.
     *
     * @param lojaId ID da loja a ser buscada.
     * @return Loja retorna a laja encontrada.
     */
    @Override
    public Loja buscarLojaPorId(int lojaId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM lojas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lojaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                List<Produto> produtos = listarProdutosDaLoja(lojaId);
                return new Loja(lojaId, nome, produtos);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar loja no MySQL", e);
        }
        return null;
    }

    /**
     * Lista todas as lojas.
     *
     * @return Lista de lojas.
     */
    @Override
    public List<Loja> listarLojas() {
        List<Loja> lojas = new ArrayList<>();
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM lojas";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int lojaId = rs.getInt("id");
                String nome = rs.getString("nome");
                List<Produto> produtos = listarProdutosDaLoja(lojaId);
                Loja loja = new Loja(lojaId, nome, produtos);
                lojas.add(loja);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar lojas no MySQL", e);
        }
        return lojas;
    }

    /**
     * Lista os produtos de uma loja.
     *
     * @param lojaId ID da loja.
     * @return Lista de produtos.
     */
    @Override
    public List<Produto> listarProdutosDaLoja(int lojaId) {
        List<Produto> produtos = new ArrayList<>();
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT p.* FROM produtos p JOIN loja_produtos lp ON p.id = lp.produto_id WHERE lp.loja_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lojaId);
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
            throw new RuntimeException("Erro ao listar produtos da loja no MySQL", e);
        }
        return produtos;
    }

    /**
     * Adiciona um produto à loja.
     *
     * @param lojaId ID da loja.
     * @param produto Produto a ser adicionado.
     */
    @Override
    public void adicionarProdutoNaLoja(int lojaId, Produto produto) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO loja_produtos (loja_id, produto_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lojaId);
            stmt.setInt(2, produto.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar produto à loja no MySQL", e);
        }
    }

    /**
     * Remove um produto da loja.
     *
     * @param lojaId ID da loja.
     * @param produtoId ID do produto.
     * @return True se o produto foi removido, false caso contrário.
     */
    @Override
    public boolean removerProdutoDaLoja(int lojaId, int produtoId) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM loja_produtos WHERE loja_id = ? AND produto_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lojaId);
            stmt.setInt(2, produtoId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover produto da loja no MySQL", e);
        }
    }

    /**
     * Retorna a representação em String do objeto.
     *
     * @return String representando o objeto.
     */
    @Override
    public String toString() {
        return "Dao (Data Access Object) de Loja em MySQL";
    }
}
