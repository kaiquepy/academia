package com.academia.cliente.controller;

import com.academia.cliente.dao.ClienteDAO;
import com.academia.cliente.model.Cliente;

/**
 * Classe ClienteController representa a camada de controle de clientes.
 *
 * Esta classe é responsável por intermediar a comunicação entre a camada de
 * visão e a camada de persistência de dados
 */
public class ClienteController {
    private final ClienteDAO clienteDAO;

    /**
     * Construtor da classe ClienteController.
     *
     * @param clientDAO DAO de cliente.
     */
    public ClienteController(ClienteDAO clientDAO) {
        this.clienteDAO = clientDAO;
    }

    /**
     * Cadastra um novo cliente.
     *
     * @param cliente Cliente a ser cadastrado.
     */
    public void cadastrarCliente(Cliente cliente) {
        clienteDAO.adicionarCliente(cliente);
    }

    /**
     * Atualiza os dados de um cliente.
     *
     * @param cliente Cliente a ser atualizado.
     */
    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

    /**
     * Remove um cliente pelo CPF.
     *
     * @param id Identificador do cliente.
     */
    public void removerCliente(int id) {
        clienteDAO.removerCliente(id);
    }

    /**
     * Busca um cliente pelo CPF.
     *
     * @param id Identificador do cliente.
     * @return Cliente
     */
    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarClientePorId(id);
    }

    /**
     * Lista todos os clientes cadastrados.
     */
    public void listarClientes() {
        clienteDAO.listarClientes().forEach(c -> System.out.println("Cliente: " + c.getNome()));
    }
}
