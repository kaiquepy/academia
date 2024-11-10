package com.academia.produto.dao;

import com.academia.produto.model.Produto;

import java.util.List;

public interface ProdutoDAO {
    void adicionarProduto(Produto produto);
    boolean removerProduto(int id);
    boolean atualizarProduto(Produto produto);
    Produto buscarProdutoPorId(int id);
    List<Produto> listarProdutos();
}
