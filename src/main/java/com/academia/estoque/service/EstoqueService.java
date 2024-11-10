package com.academia.estoque.service;

import com.academia.estoque.dao.EstoqueDAO;
import com.academia.estoque.dao.EstoqueDAOJSON;
import com.academia.estoque.dao.EstoqueDAOMySQL;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.Properties;

public class EstoqueService {
    private final EstoqueDAO estoqueDAO;

    public EstoqueService() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.estoqueDAO = new EstoqueDAOJSON();
            } else {
                this.estoqueDAO = new EstoqueDAOMySQL();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
    }

    public void adicionarEstoque(int produtoId, int quantidade) {
        if (quantidade > 0) {
            estoqueDAO.adicionarEstoque(produtoId, quantidade);
        } else {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero para adicionar ao estoque.");
        }
    }

    public void atualizarEstoque(int produtoId, int novaQuantidade) {
        if (novaQuantidade >= 0) {
            estoqueDAO.atualizarEstoque(produtoId, novaQuantidade);
        } else {
            throw new IllegalArgumentException("A quantidade do estoque não pode ser negativa.");
        }
    }

    public void removerEstoque(int produtoId) {
        estoqueDAO.removerEstoque(produtoId);
    }

    public void reduzirEstoque(int produtoId, int quantidade) {
        int quantidadeAtual = estoqueDAO.buscarQuantidadePorProdutoId(produtoId);
        if (quantidadeAtual >= quantidade) {
            estoqueDAO.atualizarEstoque(produtoId, quantidadeAtual - quantidade);
        } else {
            throw new RuntimeException("Estoque insuficiente para o produto ID: " + produtoId);
        }
    }

    public int buscarQuantidadePorProdutoId(int produtoId) {
        return estoqueDAO.buscarQuantidadePorProdutoId(produtoId);
    }
}
