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
    void adicionarCliente(Cliente cliente);
    void removerCliente(String cpf);
    void atualizarCliente(Cliente cliente);
    Cliente buscarClientePorCpf(String cpf);
    List<Cliente> listarClientes();
}
