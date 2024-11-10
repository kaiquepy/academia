package com.academia.produto.dao;

import com.academia.produto.model.Produto;

import java.util.List;

/**
 * Interface que define os métodos que devem ser implementados por uma classe que realiza operações de CRUD em um produto.
 */
public interface ProdutoDAO {
    /**
     * Adiciona um novo produto.
     *
     * @param produto a ser adicionado.
     */
    void adicionarProduto(Produto produto);

    /**
     * Remove um produto pelo ID.
     *
     * @param id Identificador do produto.
     * @return boolean true se o produto for removido, false caso contrário.
     */
    boolean removerProduto(int id);

    /**
     * Atualiza os dados de um produto.
     *
     * @param produto produto a ser atualizado.
     * @return boolean true se o produto for atualizado, false caso contrário.
     */
    boolean atualizarProduto(Produto produto);

    /**
     * Busca um produto pelo ID.
     *
     * @param id Identificador do produto.
     * @return Produto encontrado.
     */
    Produto buscarProdutoPorId(int id);

    /**
     * Lista todos os produtos cadastrados.
     *
     * @return List<Produto> Lista de produtos.
     */
    List<Produto> listarProdutos();
}
