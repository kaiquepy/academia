package com.academia.loja.dao;

import com.academia.loja.model.Loja;
import com.academia.produto.model.Produto;

import java.util.List;

public interface LojaDAO {
    void adicionarLoja(Loja loja);
    void atualizarLoja(Loja loja);
    void removerLoja(int lojaId);
    Loja buscarLojaPorId(int lojaId);
    List<Loja> listarLojas();
    void adicionarProdutoNaLoja(int lojaId, Produto produto);
    boolean removerProdutoDaLoja(int lojaId, int produtoId);
    List<Produto> listarProdutosDaLoja(int lojaId);
}
