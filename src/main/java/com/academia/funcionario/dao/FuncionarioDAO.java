package com.academia.funcionario.dao;

import com.academia.funcionario.model.Funcionario;

import java.util.ArrayList;

/**
 * Interface FuncionarioDAO representa as operações de acesso a dados para a entidade Funcionário.
 *
 * Métodos desta interface permitem a adição, remoção, atualização,
 * busca e listagem de funcionários em um sistema de persistência de dados.
 */
public interface FuncionarioDAO {
    /**
     * Adiciona um novo funcionário.
     *
     * @param funcionario Funcionário a ser adicionado.
     */
    void adicionarFuncionario(Funcionario funcionario);

    /**
     * Remove um funcionário pelo ID.
     *
     * @param id Identificador do funcionário.
     */
    void removerFuncionario(int id);

    /**
     * Atualiza os dados de um funcionário.
     *
     * @param funcionario Funcionário a ser atualizado.
     */
    void atualizarFuncionario(Funcionario funcionario);

    /**
     * Busca um funcionário pelo ID.
     *
     * @param id Identificador do funcionário.
     * @return Funcionario
     */
    Funcionario buscarFuncionarioPorID(int id);

    /**
     * Lista todos os funcionários cadastrados.
     *
     * @return List<> de funcionários.
     */
    ArrayList<Funcionario> listarFuncionarios();
}
