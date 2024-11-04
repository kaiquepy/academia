package com.academia.cliente.dao;

import com.academia.cliente.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da interface ClienteDAO para persistência de dados em JSON.
 */
public class ClienteDAOJSON implements ClienteDAO {
    /**
     * @param cliente
     */
    @Override
    public void adicionarCliente(Cliente cliente) {
        System.out.println("Adicionando cliente no JSON: " + cliente.getNome());
    }

    /**
     * @param cpf
     */
    @Override
    public void removerCliente(String cpf) {
        System.out.println("Removendo cliente no JSON com CPF: " + cpf);
    }

    /**
     * @param cliente
     */
    @Override
    public void atualizarCliente(Cliente cliente) {
        System.out.println("Atualizando cliente no JSON com CPF: " + cliente.getCpf());
    }

    /**
     * @param cpf
     * @return Cliente
     */
    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        System.out.println("Buscando cliente no JSON com CPF: " + cpf);
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Cliente> listarClientes() {
        System.out.println("Listando clientes do JSON...");
        return new ArrayList<>();
    }
}
