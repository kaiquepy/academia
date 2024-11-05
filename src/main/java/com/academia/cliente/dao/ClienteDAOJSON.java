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
     * @param cpf Cadastro de pessoa física do cliente.
     */
    @Override
    public void removerCliente(String cpf) {
        System.out.println("Removendo cliente no JSON com CPF: " + cpf);
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
     * @param cpf Cadastro de pessoa física do cliente.
     * @return Cliente
     */
    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        System.out.println("Buscando cliente no JSON com CPF: " + cpf);
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
