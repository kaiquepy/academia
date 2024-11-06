package com.academia.cliente.dao;

import com.academia.cliente.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da interface ClienteDAO para persistência de dados em JSON.
 */
public class ClienteDAOJSON implements ClienteDAO {
    /**
     * Adiciona um novo cliente.
     *
     * @param cliente Cliente a ser adicionado.
     */
    @Override
    public void adicionarCliente(Cliente cliente) {
        System.out.println("Adicionando cliente no JSON: " + cliente.getNome());
    }

    /**
     * Remove um cliente pelo CPF.
     *
     * @param id Identificador do cliente.
     */
    @Override
    public void removerCliente(int id) {
        System.out.println("Removendo cliente no JSON com Id: " + id);
    }

    /**
     * Atualiza os dados de um cliente.
     *
     * @param cliente Cliente a ser atualizado.
     */
    @Override
    public void atualizarCliente(Cliente cliente) {
        System.out.println("Atualizando cliente no JSON com CPF: " + cliente.getCpf());
    }

    /**
     * Busca um cliente pelo CPF.
     *
     * @param id Identificador do cliente.
     * @return Cliente
     */
    @Override
    public Cliente buscarClientePorId(int id) {
        System.out.println("Buscando cliente no JSON com Id: " + id);
        return null;
    }

    /**
     * Lista todos os clientes cadastrados.
     *
     * @return List<Cliente>
     */
    @Override
    public List<Cliente> listarClientes() {
        System.out.println("Listando clientes do JSON...");
        return new ArrayList<>();
    }
}
