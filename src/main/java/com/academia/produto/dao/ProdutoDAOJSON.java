package com.academia.produto.dao;

import com.academia.produto.model.Produto;
import com.academia.storage.StorageJSON;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de acesso a dados (DAO) para Produto em JSON.
 */
public class ProdutoDAOJSON implements ProdutoDAO{
    private final StorageJSON<Produto> storage;

    /**
     * Construtor da classe.
     */
    public ProdutoDAOJSON() {
        Type produtoListType = new TypeToken<List<Produto>>() {}.getType();
        this.storage = new StorageJSON<>(produtoListType, "produtos.json");
    }

    /**
     * Método para adicionar um produto.
     *
     * @param produto a ser adicionado.
     */
    @Override
    public void adicionarProduto(Produto produto) {
        List<Produto> produtos = storage.load();
        if (produtos == null) {
            produtos = new ArrayList<>();
        }

        int newId = produtos.stream().mapToInt(Produto::getId).max().orElse(0) + 1;
        produto.setId(newId);
        produtos.add(produto);
        storage.save(produtos);
    }

    /**
     * Método para remover um produto por ID.
     *
     * @param id ID do produto a ser removido.
     * @return boolean true se o produto foi removido, false caso contrário.
     */
    @Override
    public boolean removerProduto(int id) {
        List<Produto> produtos = storage.load();
        if (produtos != null) {
            produtos = produtos.stream()
                    .filter(produto -> produto.getId() != id)
                    .collect(Collectors.toList());
            storage.save(produtos);
            return true;
        }
        return false;
    }

    /**
     * Método para atualizar os dados de um produto.
     *
     * @param produto Produto a ser atualizado.
     * @return boolean true se o produto foi atualizado, false caso contrário.
     */
    @Override
    public boolean atualizarProduto(Produto produto) {
        List<Produto> produtos = storage.load();
        if (produtos != null) {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getId() == produto.getId()) {
                    produtos.set(i, produto);
                    storage.save(produtos);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método para buscar um produto por ID.
     *
     * @param id ID do produto a ser buscado.
     * @return Produto encontrado.
     */
    @Override
    public Produto buscarProdutoPorId(int id) {
        List<Produto> produtos = storage.load();
        if (produtos != null) {
            for (Produto produto : produtos) {
                if (produto.getId() == id) {
                    return produto;
                }
            }
        }
        return null;
    }

    /**
     * Método para listar todos os produtos.
     *
     * @return Lista de produtos.
     */
    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtos = storage.load();
        return produtos != null ? new ArrayList<>(produtos) : new ArrayList<>();
    }

    /**
     * Sobrescrita do método toString para retornar o storage utilizado.
     *
     * @return String com o storage de produto.
     */
    @Override
    public String toString() {
        return "ProdutoDAOJSON{" +
                "storage=" + storage +
                '}';
    }
}
