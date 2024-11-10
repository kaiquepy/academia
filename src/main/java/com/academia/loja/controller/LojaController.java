package com.academia.loja.controller;


import com.academia.loja.model.Loja;
import com.academia.loja.service.LojaService;
import com.academia.produto.model.Produto;

import java.util.List;

public class LojaController {
    private final LojaService lojaService  = new LojaService();

    public LojaController() {
    }

    public void adicionarLoja(Loja loja) {
        lojaService.adicionarLoja(loja);
    }

    public void atualizarLoja(Loja loja) {
        lojaService.atualizarLoja(loja);
    }

    public void removerLoja(int lojaId) {
        lojaService.removerLoja(lojaId);
    }

    public Loja buscarLojaPorId(int lojaId) {
        return lojaService.buscarLojaPorId(lojaId);
    }

    public List<Loja> listarLojas() {
        return lojaService.listarLojas();
    }

    public void adicionarProdutoNaLoja(int lojaId, int produtoId, int quantidade) {
        lojaService.adicionarProdutoNaLoja(lojaId, produtoId);
    }

    public void removerProdutoDaLoja(int lojaId, int produtoId) {
        lojaService.removerProdutoDaLoja(lojaId, produtoId);
    }

    public List<Produto> listarProdutosDaLoja(int lojaId) {
        return lojaService.listarProdutosDaLoja(lojaId);
    }
}
