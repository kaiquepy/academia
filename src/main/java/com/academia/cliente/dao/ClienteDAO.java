package com.academia.cliente.dao;

import com.academia.cliente.model.Cliente;

import java.util.List;

/**
 * Interface ClienteDAO representa as operações de acesso a dados para a entidade Cliente.
 *
 * Métodos desta interface permitem a adição, remoção, atualização,
 * busca e listagem de clientes em um sistema de persistência de dados.
 */
public interface ClienteDAO {
    /**
     * Adiciona um novo cliente.
     *
     * @param cliente Cliente a ser adicionado.
     */
    void adicionarCliente(Cliente cliente);

    /**
     * Remove um cliente pelo CPF.
     *
     * @param cpf Cadastro de pessoa física do cliente.
     */
    void removerCliente(String cpf);

    /**
     * Atualiza os dados de um cliente.
     *
     * @param cliente Cliente a ser atualizado.
     */
    void atualizarCliente(Cliente cliente);

    /**
     * Busca um cliente pelo CPF.
     *
     * @param cpf Cadastro de pessoa física do cliente.
     * @return Cliente
     */
    Cliente buscarClientePorCpf(String cpf);

    /**
     * Lista todos os clientes cadastrados.
     *
     * @return List<Cliente>
     */
    List<Cliente> listarClientes();
}
