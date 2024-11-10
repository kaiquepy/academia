package com.academia.venda.dao;

import com.academia.venda.model.Venda;

import java.util.List;

/*
 * Interface para VendaDAO.
 */
public interface VendaDAO {
    /*
     * Método para adicionar uma venda.
     *
     * @param venda Venda a ser adicionada.
     */
    void adicionarVenda(Venda venda);

    /*
     * Método para buscar uma venda por ID.
     *
     * @param id ID da venda a ser buscada.
     * @return Venda encontrada.
     */
    Venda buscarVendaPorId(int id);

    /*
     * Método para listar todas as vendas.
     *
     * @return Lista de vendas.
     */
    List<Venda> listarVendas();
}
