package com.academia.sala.controller;

import com.academia.sala.dao.SalaDAO;
import com.academia.sala.dao.SalaDAOJSON;
import com.academia.sala.dao.SalaDAOMySQL;
import com.academia.sala.model.Sala;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SalaController {
    private final SalaDAO salaDAO;

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

    public void adicionarSala(Sala sala) {
        salaDAO.adicionarSala(sala);
    }

    public boolean removerSala(int id) {
        return salaDAO.removerSala(id);
    }

    public boolean atualizarSala(Sala sala) {
        return salaDAO.atualizarSala(sala);
    }

    public Sala buscarSalaPorId(int id) {
        return salaDAO.buscarSalaPorId(id);
    }

    public List<Sala> listarSalas() {
        return salaDAO.listarSalas();
    }
}
