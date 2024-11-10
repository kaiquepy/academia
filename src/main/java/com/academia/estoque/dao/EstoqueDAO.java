package com.academia.estoque.dao;

public interface EstoqueDAO {
    void adicionarEstoque(int produtoId, int quantidade);
    void atualizarEstoque(int produtoId, int quantidade);
    void removerEstoque(int produtoId);
    int buscarQuantidadePorProdutoId(int produtoId);
}
