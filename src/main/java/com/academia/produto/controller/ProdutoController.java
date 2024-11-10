package com.academia.produto.controller;

import com.academia.produto.model.Produto;
import com.academia.produto.service.ProdutoService;

import java.util.List;

/**
 * Classe de controle para Produto.
 */
public class ProdutoController {
    private final ProdutoService produtoService = new ProdutoService();

    /**
     * Método para adicionar um produto.
     *
     * @param produto Produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        produtoService.adicionarProduto(produto);
    }

    /**
     * Método para atualizar os dados de um produto.
     *
     * @param produto Produto a ser atualizado.
     */
    public void atualizarProduto(Produto produto) {
        produtoService.atualizarProduto(produto);
    }

    /**
     * Método para remover um produto por ID.
     *
     * @param produtoId ID do produto a ser removido.
     */
    public void removerProduto(int produtoId) {
        produtoService.removerProduto(produtoId);
    }

    /**
     * Método para buscar um produto por ID.
     *
     * @param produtoId ID do produto a ser buscado.
     * @return Produto encontrado.
     */
    public Produto buscarProdutoPorId(int produtoId) {
        return produtoService.buscarProdutoPorId(produtoId);
    }

    /**
     * Método para listar todos os produtos.
     *
     * @return Lista de produtos.
     */
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
