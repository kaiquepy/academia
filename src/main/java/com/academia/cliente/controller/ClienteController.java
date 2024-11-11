package com.academia.cliente.controller;

import com.academia.cliente.dao.ClienteDAO;
import com.academia.cliente.dao.ClienteDAOJSON;
import com.academia.cliente.dao.ClienteDAOMySQL;
import com.academia.cliente.model.Cliente;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.Properties;

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
     */
    public ClienteController() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.clienteDAO = new ClienteDAOJSON();
            } else {
                this.clienteDAO = new ClienteDAOMySQL();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
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
        clienteDAO.listarClientes().forEach(System.out::println);
    }

    /**
     * Retorna a representação em String do objeto ClienteController.
     *
     * @return String clienteDAO.
     */
    @Override
    public String toString() {
        return "ClienteController{" +
                "clienteDAO=" + clienteDAO +
                '}';
    }
}
