package com.academia.cliente.dao;

import com.academia.cliente.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da interface ClienteDAO para persistência de dados em MySQL.
 */
public class ClienteDAOMySQL implements ClienteDAO {
    /**
     * @param cliente
     */
    @Override
    public void adicionarCliente(Cliente cliente) {
        System.out.println("Adicionando cliente no MySQL: " + cliente.getNome());
    }

    /**
     * @param cpf
     */
    @Override
    public void removerCliente(String cpf) {
        System.out.println("Removendo cliente no MySQL com CPF: " + cpf);
    }

    /**
     * @param cliente
     */
    @Override
    public void atualizarCliente(Cliente cliente) {
        System.out.println("Atualizando cliente no MySQL com CPF: " + cliente.getCpf());
    }

    /**
     * @param cpf
     * @return Cliente
     */
    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        System.out.println("Buscando cliente no MySQL com CPF: " + cpf);
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Cliente> listarClientes() {
        System.out.println("Listando clientes do MySQL...");
        return new ArrayList<>();
    }
}
