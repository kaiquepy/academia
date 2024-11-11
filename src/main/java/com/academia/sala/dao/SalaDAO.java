package com.academia.sala.dao;

import com.academia.sala.model.Sala;

import java.util.List;

/**
 * Interface que define os métodos que devem ser implementados por uma classe que realiza operações de CRUD em uma sala.
 */
public interface SalaDAO {
    /**
     * Adiciona uma nova sala.
     *
     * @param sala Sala a ser adicionada.
     */
    void adicionarSala(Sala sala);

    /**
     * Remove uma sala pelo ID.
     *
     * @param id Identificador da sala.
     * @return boolean
     */
    boolean removerSala(int id);

    /**
     * Lista todas as salas cadastradas.
     *
     * @return List<> de salas.
     */
    List<Sala> listarSalas();

    /**
     * Busca uma sala pelo ID.
     *
     * @param id Identificador da sala.
     * @return Sala
     */
    Sala buscarSalaPorId(int id);

    /**
     * Atualiza os dados de uma sala.
     *
     * @param sala Sala a ser atualizada.
     * @return boolean
     */
    boolean atualizarSala(Sala sala);
}
