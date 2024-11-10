package com.academia.produto.controller;

import com.academia.produto.model.Produto;
import com.academia.produto.service.ProdutoService;

import java.util.List;

public class ProdutoController {
    private final ProdutoService produtoService = new ProdutoService();

    public void adicionarProduto(Produto produto) {
        produtoService.adicionarProduto(produto);
    }

    public void atualizarProduto(Produto produto) {
        produtoService.atualizarProduto(produto);
    }

    public void removerProduto(int produtoId) {
        produtoService.removerProduto(produtoId);
    }

    public Produto buscarProdutoPorId(int produtoId) {
        return produtoService.buscarProdutoPorId(produtoId);
    }

    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
