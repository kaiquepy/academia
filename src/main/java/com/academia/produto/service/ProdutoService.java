package com.academia.produto.service;

import com.academia.produto.dao.ProdutoDAO;
import com.academia.produto.dao.ProdutoDAOJSON;
import com.academia.produto.dao.ProdutoDAOMySQL;
import com.academia.produto.model.Produto;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Classe de serviço para Produto.
 */
public class ProdutoService {
    private final ProdutoDAO produtoDAO;

    /**
     * Construtor da classe.
     */
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

    /**
     * Método para adicionar um produto.
     *
     * @param produto Produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        produtoDAO.adicionarProduto(produto);
    }

    /**
     * Método para atualizar os dados de um produto.
     *
     * @param produto Produto a ser atualizado.
     */
    public void atualizarProduto(Produto produto) {
        produtoDAO.atualizarProduto(produto);
    }

    /**
     * Método para remover um produto por ID.
     *
     * @param produtoId ID do produto a ser removido.
     */
    public void removerProduto(int produtoId) {
        produtoDAO.removerProduto(produtoId);
    }

    /**
     * Método para buscar um produto por ID.
     *
     * @param produtoId ID do produto a ser buscado.
     * @return Produto encontrado.
     */
    public Produto buscarProdutoPorId(int produtoId) {
        return produtoDAO.buscarProdutoPorId(produtoId);
    }

    /**
     * Método para listar todos os produtos.
     *
     * @return Lista de produtos.
     */
    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }

    /**
     * Sobrescrita do método toString para retornar o dao utilizado.
     *
     * @return String com o dao de produto.
     */
    @Override
    public String toString() {
        return "ProdutoService{" +
                "produtoDAO=" + produtoDAO +
                '}';
    }
}
