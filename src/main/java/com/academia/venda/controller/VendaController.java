package com.academia.venda.controller;

import com.academia.venda.model.Venda;
import com.academia.venda.service.VendaService;

import java.util.List;

public class VendaController {
    private final VendaService vendaService = new VendaService();

    public void adicionarVenda(Venda venda) {
        vendaService.adicionarVenda(venda);
    }

    public Venda buscarVendaPorId(int vendaId) {
        return vendaService.buscarVendaPorId(vendaId);
    }

    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }
}
