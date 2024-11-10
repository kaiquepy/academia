package com.academia.venda.service;

import com.academia.utils.Config;
import com.academia.venda.dao.VendaDAO;
import com.academia.venda.dao.VendaDAOJSON;
import com.academia.venda.dao.VendaDAOMySQL;
import com.academia.venda.model.Venda;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/*
 * Classe de serviço para Venda.
 */
public class VendaService {
    private final VendaDAO vendaDAO;

    /*
     * Construtor da classe.
     */
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

    /*
     * Método para adicionar uma venda.
     *
     * @param venda Venda a ser adicionada.
     */
    public void adicionarVenda(Venda venda) {
        vendaDAO.adicionarVenda(venda);
    }

    /*
     * Método para buscar uma venda por ID.
     *
     * @param id ID da venda a ser buscada.
     * @return Venda encontrada.
     */
    public Venda buscarVendaPorId(int id) {
        return vendaDAO.buscarVendaPorId(id);
    }

    /*
     * Método para listar todas as vendas.
     *
     * @return Lista de vendas.
     */
    public List<Venda> listarVendas() {
        return vendaDAO.listarVendas();
    }

    /*
     * Método para obter o DAO de Venda.
     *
     * @return DAO de Venda.
     */
    @Override
    public String toString() {
        return "VendaService{" +
                "vendaDAO=" + vendaDAO +
                '}';
    }
}
