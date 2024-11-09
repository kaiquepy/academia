package com.academia.funcionario.controller;

import com.academia.funcionario.dao.FuncionarioDAO;
import com.academia.funcionario.dao.FuncionarioDAOJSON;
import com.academia.funcionario.dao.FuncionarioDAOMySQL;
import com.academia.funcionario.model.Funcionario;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class FuncionarioController {
    private final FuncionarioDAO funcionarioDAO;

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

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioDAO.adicionarFuncionario(funcionario);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarioDAO.atualizarFuncionario(funcionario);
    }

    public void removerFuncionario(int id) {
        funcionarioDAO.removerFuncionario(id);
    }

    public Funcionario buscarFuncionario(int id) {
        return funcionarioDAO.buscarFuncionarioPorID(id);
    }

    public ArrayList<Funcionario> listarFuncionarios() {
        return funcionarioDAO.listarFuncionarios();
    }
}
