package com.academia.cliente.dao;

import com.academia.cliente.model.Cliente;
import com.academia.storage.StorageJSON;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementação da interface ClienteDAO para persistência de dados em JSON.
 */
public class ClienteDAOJSON implements ClienteDAO {
    private final StorageJSON<Cliente> storage;

    public ClienteDAOJSON() {
        Type clienteListType = new TypeToken<List<Cliente>>() {}.getType();
        this.storage = new StorageJSON<>(clienteListType, "clientes.json");
    }

    /**
     * Adiciona um novo cliente.
     *
     * @param cliente Cliente a ser adicionado.
     */
    @Override
    public void adicionarCliente(Cliente cliente) {
        List<Cliente> clientes = storage.load();
        if (clientes == null) {
            clientes = new ArrayList<>();
        }

        int newId = clientes.stream().mapToInt(Cliente::getId).max().orElse(0) + 1;
        cliente.setId(newId);
        clientes.add(cliente);
        storage.save(clientes);
    }

    /**
     * Remove um cliente pelo ID.
     *
     * @param id Identificador do cliente.
     */
    @Override
    public void removerCliente(int id) {
        List<Cliente> clientes = storage.load();
        if (clientes != null) {
            clientes = clientes.stream()
                    .filter(cliente -> cliente.getId() != id)
                    .collect(Collectors.toList());
            storage.save(clientes);
        }
    }

    /**
     * Atualiza os dados de um cliente.
     *
     * @param cliente Cliente a ser atualizado.
     */
    @Override
    public void atualizarCliente(Cliente cliente) {
        List<Cliente> clientes = storage.load();
        if (clientes != null) {
            clientes = clientes.stream()
                    .map(c -> c.getId() == cliente.getId() ? cliente : c)
                    .collect(Collectors.toList());
            storage.save(clientes);
        }
    }

    /**
     * Busca um cliente pelo ID.
     *
     * @param id Identificador do cliente.
     * @return Cliente
     */
    @Override
    public Cliente buscarClientePorId(int id) {
        List<Cliente> clientes = storage.load();
        if (clientes != null) {
            Optional<Cliente> cliente = clientes.stream()
                    .filter(c -> c.getId() == id)
                    .findFirst();
            return cliente.orElse(null);
        }
        return null;
    }

    /**
     * Lista todos os clientes cadastrados.
     *
     * @return List<Cliente>
     */
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = storage.load();
        return clientes != null ? clientes : new ArrayList<>();
    }
}
