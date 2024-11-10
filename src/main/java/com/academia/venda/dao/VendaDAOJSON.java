package com.academia.venda.dao;

import com.academia.storage.StorageJSON;
import com.academia.venda.model.Venda;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VendaDAOJSON implements VendaDAO {
    private final StorageJSON<Venda> storage;

    public VendaDAOJSON() {
        Type vendaListType = new TypeToken<List<Venda>>() {}.getType();
        this.storage = new StorageJSON<>(vendaListType, "vendas.json");
    }

    @Override
    public void adicionarVenda(Venda venda) {
        List<Venda> vendas = storage.load();
        if (vendas == null) {
            vendas = new ArrayList<>();
        }

        int newId = vendas.stream().mapToInt(Venda::getId).max().orElse(0) + 1;
        venda.setId(newId);
        vendas.add(venda);
        storage.save(vendas);
    }

    @Override
    public Venda buscarVendaPorId(int id) {
        List<Venda> vendas = storage.load();
        if (vendas != null) {
            for (Venda venda : vendas) {
                if (venda.getId() == id) {
                    return venda;
                }
            }
        }
        return null;
    }

    @Override
    public List<Venda> listarVendas() {
        List<Venda> vendas = storage.load();
        return vendas != null ? new ArrayList<>(vendas) : new ArrayList<>();
    }
}
