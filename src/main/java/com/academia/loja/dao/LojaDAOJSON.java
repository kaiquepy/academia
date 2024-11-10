package com.academia.loja.dao;

import com.academia.loja.model.Loja;
import com.academia.produto.model.Produto;
import com.academia.storage.StorageJSON;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LojaDAOJSON implements LojaDAO {
    private final StorageJSON<Loja> storage;

    public LojaDAOJSON() {
        Type lojaListType = new TypeToken<List<Loja>>() {}.getType();
        this.storage = new StorageJSON<>(lojaListType, "lojas.json");
    }

    @Override
    public void adicionarLoja(Loja loja) {
        List<Loja> lojas = storage.load();
        if (lojas == null) {
            lojas = new ArrayList<>();
        }
        lojas.add(loja);
        storage.save(lojas);
    }

    @Override
    public void atualizarLoja(Loja lojaAtualizada) {
        List<Loja> lojas = storage.load();
        if (lojas != null) {
            for (int i = 0; i < lojas.size(); i++) {
                if (lojas.get(i).getId() == lojaAtualizada.getId()) {
                    lojas.set(i, lojaAtualizada);
                    break;
                }
            }
            storage.save(lojas);
        }
    }

    @Override
    public void removerLoja(int lojaId) {
        List<Loja> lojas = storage.load();
        if (lojas != null) {
            lojas = lojas.stream()
                    .filter(loja -> loja.getId() != lojaId)
                    .collect(Collectors.toList());
            storage.save(lojas);
        }
    }

    @Override
    public Loja buscarLojaPorId(int lojaId) {
        List<Loja> lojas = storage.load();
        if (lojas != null) {
            for (Loja loja : lojas) {
                if (loja.getId() == lojaId) {
                    return loja;
                }
            }
        }
        return null;
    }

    @Override
    public List<Loja> listarLojas() {
        List<Loja> lojas = storage.load();
        return lojas != null ? new ArrayList<>(lojas) : new ArrayList<>();
    }

    @Override
    public void adicionarProdutoNaLoja(int lojaId, Produto produto) {
        List<Loja> lojas = storage.load();
        if (lojas == null) {
            lojas = new ArrayList<>();
        }

        Loja lojaExistente = lojas.stream()
                .filter(loja -> loja.getId() == lojaId)
                .findFirst()
                .orElse(null);

        if (lojaExistente != null) {
            lojaExistente.getProdutos().add(produto);
        } else {
            System.out.println("Loja não encontrada.");
        }

        storage.save(lojas);
    }

    @Override
    public boolean removerProdutoDaLoja(int lojaId, int produtoId) {
        List<Loja> lojas = storage.load();
        if (lojas != null) {
            for (Loja loja : lojas) {
                if (loja.getId() == lojaId) {
                    List<Produto> produtosAtualizados = loja.getProdutos().stream()
                            .filter(produto -> produto.getId() != produtoId)
                            .collect(Collectors.toList());
                    loja.setProdutos(produtosAtualizados);
                    storage.save(lojas);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Produto> listarProdutosDaLoja(int lojaId) {
        Loja loja = buscarLojaPorId(lojaId);
        return loja != null ? loja.getProdutos() : new ArrayList<>();
    }
}
