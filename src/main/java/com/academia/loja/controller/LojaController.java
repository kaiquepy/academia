package com.academia.loja.controller;


import com.academia.loja.model.Loja;
import com.academia.loja.service.LojaService;
import com.academia.produto.model.Produto;

import java.util.List;

/**
 * Classe controladora para Loja.
 */
public class LojaController {
    private final LojaService lojaService  = new LojaService();

    /**
     * Construtor da classe.
     */
    public LojaController() {
    }

    /**
     * Método para adicionar uma loja.
     *
     * @param loja a ser adicionada.
     */
    public void adicionarLoja(Loja loja) {
        lojaService.adicionarLoja(loja);
    }

    /**
     * Método para atualizar os dados de uma loja.
     *
     * @param loja a ser atualizada.
     */
    public void atualizarLoja(Loja loja) {
        lojaService.atualizarLoja(loja);
    }

    /**
     * Método para remover uma loja por ID.
     *
     * @param lojaId ID da loja a ser removida.
     */
    public void removerLoja(int lojaId) {
        lojaService.removerLoja(lojaId);
    }

    /**
     * Método para buscar uma loja por ID.
     *
     * @param lojaId ID da loja a ser buscada.
     * @return Loja encontrada.
     */
    public Loja buscarLojaPorId(int lojaId) {
        return lojaService.buscarLojaPorId(lojaId);
    }

    /**
     * Método para listar todas as lojas.
     *
     * @return Lista de lojas.
     */
    public List<Loja> listarLojas() {
        return lojaService.listarLojas();
    }

    /**
     * Método para adicionar um produto à loja.
     *
     * @param lojaId    ID da loja.
     * @param produtoId ID do produto.
     */
    public void adicionarProdutoNaLoja(int lojaId, int produtoId, int quantidade) {
        lojaService.adicionarProdutoNaLoja(lojaId, produtoId);
    }

    /**
     * Método para remover um produto da loja.
     *
     * @param lojaId    ID da loja.
     * @param produtoId ID do produto.
     */
    public void removerProdutoDaLoja(int lojaId, int produtoId) {
        lojaService.removerProdutoDaLoja(lojaId, produtoId);
    }

    /**
     * Método para listar os produtos de uma loja.
     *
     * @param lojaId ID da loja.
     * @return Lista de produtos.
     */
    public List<Produto> listarProdutosDaLoja(int lojaId) {
        return lojaService.listarProdutosDaLoja(lojaId);
    }

    /**
     * Sobrescrita do método toString.
     *
     * @return String serviço de loja.
     */
    @Override
    public String toString() {
        return "LojaController{" +
                "lojaService=" + lojaService +
                '}';
    }
}
