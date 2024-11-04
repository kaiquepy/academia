package com.academia.cliente.controller;

import com.academia.cliente.dao.ClienteDAO;
import com.academia.cliente.model.Cliente;


public class ClienteController {
    private final ClienteDAO clienteDAO;

    public ClienteController(ClienteDAO clientDAO) {
        this.clienteDAO = clientDAO;
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteDAO.adicionarCliente(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

    public void removerCliente(String cpf) {
        clienteDAO.removerCliente(cpf);
    }

    public Cliente buscarCliente(String cpf) {
        return clienteDAO.buscarClientePorCpf(cpf);
    }

    public void listarClientes() {
        clienteDAO.listarClientes().forEach(c -> System.out.println("Cliente: " + c.getNome()));
    }
}
