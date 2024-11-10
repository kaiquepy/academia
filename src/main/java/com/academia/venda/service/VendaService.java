package com.academia.venda.service;

import com.academia.utils.Config;
import com.academia.venda.dao.VendaDAO;
import com.academia.venda.dao.VendaDAOJSON;
import com.academia.venda.dao.VendaDAOMySQL;
import com.academia.venda.model.Venda;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class VendaService {
    private final VendaDAO vendaDAO;

    public VendaService() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.vendaDAO = new VendaDAOJSON();
            } else {
                this.vendaDAO = new VendaDAOMySQL();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
    }

    public void adicionarVenda(Venda venda) {
        vendaDAO.adicionarVenda(venda);
    }

    public Venda buscarVendaPorId(int id) {
        return vendaDAO.buscarVendaPorId(id);
    }

    public List<Venda> listarVendas() {
        return vendaDAO.listarVendas();
    }
}
