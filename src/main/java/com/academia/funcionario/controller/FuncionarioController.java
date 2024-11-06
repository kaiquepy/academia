package com.academia.funcionario.controller;

import com.academia.funcionario.dao.FuncionarioDAO;
import com.academia.funcionario.model.Funcionario;

import java.util.ArrayList;

public class FuncionarioController {
    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
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
