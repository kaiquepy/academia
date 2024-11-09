package com.academia.funcionario.dao;

import com.academia.funcionario.model.Funcionario;
import com.academia.storage.StorageJSON;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDAOJSON implements FuncionarioDAO{
    private final StorageJSON<Funcionario> storage;

    public FuncionarioDAOJSON() {
        Type funcionarioListType = new TypeToken<List<Funcionario>>() {}.getType();
        this.storage = new StorageJSON<>(funcionarioListType, "funcionarios.json");
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionarios = storage.load();
        if(funcionarios == null){
            funcionarios = new ArrayList<>();
        }

        int newId = funcionarios.stream().mapToInt(Funcionario::getId).max().orElse(0) + 1;
        funcionario.setId(newId);
        funcionarios.add(funcionario);
        storage.save(funcionarios);
    }

    @Override
    public void removerFuncionario(int id) {
        List<Funcionario> funcionarios = storage.load();
        if (funcionarios != null) {
            funcionarios = funcionarios.stream()
                    .filter(funcionario -> funcionario.getId() != id)
                    .collect(Collectors.toList());
            storage.save(funcionarios);
        }
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionarios = storage.load();
        if (funcionarios != null) {
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getId() == funcionario.getId()) {
                    funcionarios.set(i, funcionario);
                    break;
                }
            }
            storage.save(funcionarios);
        }
    }

    @Override
    public Funcionario buscarFuncionarioPorID(int id) {
        List<Funcionario> funcionarios = storage.load();
        if (funcionarios != null) {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getId() == id) {
                    return funcionario;
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionario = storage.load();
        return funcionario != null ? new ArrayList<>(funcionario) : new ArrayList<>();
    }
}
