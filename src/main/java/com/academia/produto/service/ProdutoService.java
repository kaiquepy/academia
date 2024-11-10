package com.academia.produto.service;

import com.academia.produto.dao.ProdutoDAO;
import com.academia.produto.dao.ProdutoDAOJSON;
import com.academia.produto.dao.ProdutoDAOMySQL;
import com.academia.produto.model.Produto;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ProdutoService {
    private final ProdutoDAO produtoDAO;

    public ProdutoService() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.produtoDAO = new ProdutoDAOJSON();
            } else {
                this.produtoDAO = new ProdutoDAOMySQL();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
    }

    public void adicionarProduto(Produto produto) {
        produtoDAO.adicionarProduto(produto);
    }

    public void atualizarProduto(Produto produto) {
        produtoDAO.atualizarProduto(produto);
    }

    public void removerProduto(int produtoId) {
        produtoDAO.removerProduto(produtoId);
    }

    public Produto buscarProdutoPorId(int produtoId) {
        return produtoDAO.buscarProdutoPorId(produtoId);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }
}
