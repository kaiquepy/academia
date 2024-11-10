package com.academia.venda.dao;

import com.academia.produto.model.Produto;
import com.academia.storage.StorageMySQL;
import com.academia.venda.model.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendaDAOMySQL implements VendaDAO {
    @Override
    public void adicionarVenda(Venda venda) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO vendas (valor_total, data_venda) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, venda.getValorTotal());
            stmt.setDate(2, java.sql.Date.valueOf(venda.getDataVenda()));
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int vendaId = generatedKeys.getInt(1);
                for (Produto produto : venda.getProdutos()) {
                    String produtoSql = "INSERT INTO venda_produtos (venda_id, produto_id) VALUES (?, ?)";
                    PreparedStatement produtoStmt = conn.prepareStatement(produtoSql);
                    produtoStmt.setInt(1, vendaId);
                    produtoStmt.setInt(2, produto.getId());
                    produtoStmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar venda no MySQL", e);
        }
    }

    @Override
    public Venda buscarVendaPorId(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM vendas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                List<Produto> produtos = listarProdutosDaVenda(id, conn);
                return new Venda(id, produtos, rs.getDouble("valor_total"), rs.getDate("data_venda").toLocalDate());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar venda no MySQL", e);
        }
        return null;
    }

    @Override
    public List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM vendas";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int vendaId = rs.getInt("id");
                List<Produto> produtos = listarProdutosDaVenda(vendaId, conn);
                Venda venda = new Venda(vendaId, produtos, rs.getDouble("valor_total"), rs.getDate("data_venda").toLocalDate());
                vendas.add(venda);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar vendas no MySQL", e);
        }
        return vendas;
    }

    private List<Produto> listarProdutosDaVenda(int vendaId, Connection conn) {
        List<Produto> produtos = new ArrayList<>();
        try {
            String sql = "SELECT p.* FROM produtos p JOIN venda_produtos vp ON p.id = vp.produto_id WHERE vp.venda_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, vendaId);
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
            throw new RuntimeException("Erro ao listar produtos da venda no MySQL", e);
        }
        return produtos;
    }
}
