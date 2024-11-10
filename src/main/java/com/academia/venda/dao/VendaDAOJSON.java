package com.academia.venda.dao;

import com.academia.storage.StorageJSON;
import com.academia.venda.model.Venda;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/*
 * Classe de acesso a dados (DAO) para Venda em JSON.
 */
public class VendaDAOJSON implements VendaDAO {
    private final StorageJSON<Venda> storage;

    /*
     * Construtor da classe.
     */
    public VendaDAOJSON() {
        Type vendaListType = new TypeToken<List<Venda>>() {}.getType();
        this.storage = new StorageJSON<>(vendaListType, "vendas.json");
    }

    /*
     * Método para adicionar uma venda.
     *
     * @param venda Venda a ser adicionada.
     */
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

    /*
     * Método para buscar uma venda por ID.
     *
     * @param id ID da venda a ser buscada.
     * @return Venda encontrada.
     */
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

    /*
     * Método para listar todas as vendas.
     *
     * @return Lista de vendas.
     */
    @Override
    public List<Venda> listarVendas() {
        List<Venda> vendas = storage.load();
        return vendas != null ? new ArrayList<>(vendas) : new ArrayList<>();
    }

    /*
     * Sobrescrita do método toString para retornar o Storage.
     *
     * @return Storage da classe.
     */
    @Override
    public String toString() {
        return "VendaDAOJSON{" +
                "storage=" + storage +
                '}';
    }
}
