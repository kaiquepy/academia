package com.academia.funcionario.controller;

import com.academia.funcionario.dao.FuncionarioDAO;
import com.academia.funcionario.dao.FuncionarioDAOJSON;
import com.academia.funcionario.dao.FuncionarioDAOMySQL;
import com.academia.funcionario.model.Funcionario;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Classe de controle para Funcionário.
 */
public class FuncionarioController {
    private final FuncionarioDAO funcionarioDAO;

    /**
     * Construtor da classe.
     */
    public FuncionarioController() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.funcionarioDAO = new FuncionarioDAOJSON();
            } else {
                this.funcionarioDAO = new FuncionarioDAOMySQL();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
    }

    /**
     * Método para adicionar um funcionário.
     *
     * @param funcionario a ser adicionado.
     */
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioDAO.adicionarFuncionario(funcionario);
    }

    /**
     * Método para atualizar os dados de um funcionário.
     *
     * @param funcionario a ser atualizado.
     */
    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarioDAO.atualizarFuncionario(funcionario);
    }

    /**
     * Método para remover um funcionário por ID.
     *
     * @param id do funcionário a ser removido.
     */
    public void removerFuncionario(int id) {
        funcionarioDAO.removerFuncionario(id);
    }

    /**
     * Método para buscar um funcionário por ID.
     *
     * @param id do funcionário a ser buscado.
     * @return Funcionario encontrado.
     */
    public Funcionario buscarFuncionario(int id) {
        return funcionarioDAO.buscarFuncionarioPorID(id);
    }

    /**
     * Método para listar todos os funcionários.
     *
     * @return Lista de funcionários.
     */
    public ArrayList<Funcionario> listarFuncionarios() {
        return funcionarioDAO.listarFuncionarios();
    }

    /**
     * Método para retornar o DAO do funcionário.
     *
     * @return FuncionarioDAO.
     */
    @Override
    public String toString() {
        return "FuncionarioController{" +
                "funcionarioDAO=" + funcionarioDAO +
                '}';
    }
}
