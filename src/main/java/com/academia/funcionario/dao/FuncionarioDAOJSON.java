package com.academia.funcionario.dao;

import com.academia.funcionario.model.Funcionario;
import com.academia.storage.StorageJSON;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de acesso a dados (DAO) para Funcionário em JSON.
 */
public class FuncionarioDAOJSON implements FuncionarioDAO{
    private final StorageJSON<Funcionario> storage;

    /**
     * Construtor da classe.
     */
    public FuncionarioDAOJSON() {
        Type funcionarioListType = new TypeToken<List<Funcionario>>() {}.getType();
        this.storage = new StorageJSON<>(funcionarioListType, "funcionarios.json");
    }

    /**
     * Adiciona um novo funcionário.
     *
     * @param funcionario Funcionário a ser adicionado.
     */
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

    /**
     * Remove um funcionário pelo ID.
     *
     * @param id Identificador do funcionário.
     */
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

    /**
     * Atualiza os dados de um funcionário.
     *
     * @param funcionario Funcionário a ser atualizado.
     */
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

    /**
     * Busca um funcionário pelo ID.
     *
     * @param id Identificador do funcionário.
     * @return Funcionario ou null se não encontrado.
     */
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

    /**
     * Lista todos os funcionários cadastrados.
     *
     * @return Lista de funcionários.
     */
    @Override
    public ArrayList<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionario = storage.load();
        return funcionario != null ? new ArrayList<>(funcionario) : new ArrayList<>();
    }

    /**
     * Retorna uma representação em String do objeto.
     *
     * @return String representando o objeto.
     */
    @Override
    public String toString() {
        return "FuncionarioDAOJSON{" +
                "storage=" + storage +
                '}';
    }
}
