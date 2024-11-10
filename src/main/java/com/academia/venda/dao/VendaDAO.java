package com.academia.venda.dao;

import com.academia.venda.model.Venda;

import java.util.List;

public interface VendaDAO {
    void adicionarVenda(Venda venda);
    Venda buscarVendaPorId(int id);
    List<Venda> listarVendas();
}
