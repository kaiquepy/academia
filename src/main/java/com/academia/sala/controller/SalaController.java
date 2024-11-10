package com.academia.sala.controller;

import com.academia.sala.dao.SalaDAO;
import com.academia.sala.dao.SalaDAOJSON;
import com.academia.sala.dao.SalaDAOMySQL;
import com.academia.sala.model.Sala;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Classe de serviço para Sala.
 */
public class SalaController {
    private final SalaDAO salaDAO;

    /**
     * Construtor da classe.
     */
    public SalaController() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.salaDAO = new SalaDAOJSON();
            } else {
                this.salaDAO = new SalaDAOMySQL();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
    }

    /**
     * Método para adicionar uma sala.
     *
     * @param sala Sala a ser adicionada.
     */
    public void adicionarSala(Sala sala) {
        salaDAO.adicionarSala(sala);
    }

    /**
     * Método para remover uma sala por ID.
     *
     * @param id ID da sala a ser removida.
     * @return boolean true se a sala for removida, false caso contrário.
     */
    public boolean removerSala(int id) {
        return salaDAO.removerSala(id);
    }

    /**
     * Método para atualizar os dados de uma sala.
     *
     * @param sala Sala a ser atualizada.
     * @return boolean true se a sala for atualizada, false caso contrário.
     */
    public boolean atualizarSala(Sala sala) {
        return salaDAO.atualizarSala(sala);
    }

    /**
     * Método para buscar uma sala por ID.
     *
     * @param id ID da sala a ser buscada.
     * @return Sala encontrada.
     */
    public Sala buscarSalaPorId(int id) {
        return salaDAO.buscarSalaPorId(id);
    }

    /**
     * Método para listar todas as salas.
     *
     * @return Lista de salas.
     */
    public List<Sala> listarSalas() {
        return salaDAO.listarSalas();
    }

    /**
     * Método para obter o DAO de Sala.
     *
     * @return DAO de Sala.
     */
    @Override
    public String toString() {
        return "SalaController{" +
                "salaDAO=" + salaDAO +
                '}';
    }
}
