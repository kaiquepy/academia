package com.academia.estoque.controller;

import com.academia.estoque.service.EstoqueService;

public class EstoqueController {
    private final EstoqueService estoqueService = new EstoqueService();

    public void adicionarEstoque(int produtoId, int quantidade) {
        estoqueService.adicionarEstoque(produtoId, quantidade);
    }

    public void atualizarEstoque(int produtoId, int quantidade) {
        estoqueService.atualizarEstoque(produtoId, quantidade);
    }

    public void removerEstoque(int produtoId) {
        estoqueService.removerEstoque(produtoId);
    }

    public int buscarQuantidadePorProdutoId(int produtoId) {
        return estoqueService.buscarQuantidadePorProdutoId(produtoId);
    }
}
