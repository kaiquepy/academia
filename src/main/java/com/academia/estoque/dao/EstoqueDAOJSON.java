package com.academia.estoque.dao;

import com.academia.estoque.model.Estoque;
import com.academia.storage.StorageJSON;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class EstoqueDAOJSON implements EstoqueDAO {
    private final StorageJSON<Estoque> storage;
    private final List<Estoque> estoqueList;

    public EstoqueDAOJSON() {
        Type estoqueListType = new TypeToken<List<Estoque>>() {}.getType();
        this.storage = new StorageJSON<>(estoqueListType, "estoque.json");
        this.estoqueList = storage.load();
    }

    @Override
    public void adicionarEstoque(int produtoId, int quantidade) {
        Estoque estoque = buscarEstoquePorProdutoId(produtoId);
        if (estoque != null) {
            estoque.setQuantidade(estoque.getQuantidade() + quantidade);
        } else {
            estoque = new Estoque(produtoId, quantidade);
            estoqueList.add(estoque);
        }
        storage.save(estoqueList);
    }

    @Override
    public void atualizarEstoque(int produtoId, int quantidade) {
        Estoque estoque = buscarEstoquePorProdutoId(produtoId);
        if (estoque != null) {
            estoque.setQuantidade(quantidade);
            storage.save(estoqueList);
        } else {
            throw new RuntimeException("Produto não encontrado no estoque com ID: " + produtoId);
        }
    }

    @Override
    public void removerEstoque(int produtoId) {
        Estoque estoque = buscarEstoquePorProdutoId(produtoId);
        if (estoque != null) {
            estoqueList.remove(estoque);
            storage.save(estoqueList);
        } else {
            throw new RuntimeException("Produto não encontrado no estoque com ID: " + produtoId);
        }
    }

    @Override
    public int buscarQuantidadePorProdutoId(int produtoId) {
        Estoque estoque = buscarEstoquePorProdutoId(produtoId);
        return (estoque != null) ? estoque.getQuantidade() : 0;
    }

    private Estoque buscarEstoquePorProdutoId(int produtoId) {
        for (Estoque estoque : estoqueList) {
            if (estoque.getProdutoId() == produtoId) {
                return estoque;
            }
        }
        return null;
    }
}
