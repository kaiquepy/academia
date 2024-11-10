package com.academia.loja.dao;

import com.academia.loja.model.Loja;
import com.academia.produto.model.Produto;

import java.util.List;

/**
 * Interface para LojaDAO.
 */
public interface LojaDAO {
    /**
     * Método para adicionar uma loja.
     *
     * @param loja Loja a ser adicionada.
     */
    void adicionarLoja(Loja loja);

    /**
     * Método para atualizar os dados de uma loja.
     *
     * @param loja Loja a ser atualizada.
     */
    void atualizarLoja(Loja loja);

    /**
     * Método para remover uma loja por ID.
     *
     * @param lojaId ID da loja a ser removida.
     */
    void removerLoja(int lojaId);

    /**
     * Método para buscar uma loja por ID.
     *
     * @param lojaId ID da loja a ser buscada.
     * @return Loja encontrada.
     */
    Loja buscarLojaPorId(int lojaId);

    /**
     * Método para listar todas as lojas.
     *
     * @return Lista de lojas.
     */
    List<Loja> listarLojas();

    /**
     * Método para adicionar um produto à loja.
     *
     * @param lojaId   ID da loja.
     * @param produto Produto a ser adicionado.
     */
    void adicionarProdutoNaLoja(int lojaId, Produto produto);

    /**
     * Método para remover um produto da loja.
     *
     * @param lojaId    ID da loja.
     * @param produtoId ID do produto.
     * @return True se o produto foi removido, false caso contrário.
     */
    boolean removerProdutoDaLoja(int lojaId, int produtoId);

    /**
     * Método para listar os produtos de uma loja.
     *
     * @param lojaId ID da loja.
     * @return Lista de produtos.
     */
    List<Produto> listarProdutosDaLoja(int lojaId);
}
