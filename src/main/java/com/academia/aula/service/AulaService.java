package com.academia.aula.service;

import com.academia.aula.dao.AulaDAO;
import com.academia.aula.dao.AulaDAOJSON;
import com.academia.aula.dao.AulaDAOMySQL;
import com.academia.aula.model.Aula;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class AulaService {
    private final AulaDAO aulaDAO;

    public AulaService() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.aulaDAO = new AulaDAOJSON();
            } else {
                this.aulaDAO = new AulaDAOMySQL();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
    }

    public void adicionarAula(Aula aula) {
        aulaDAO.adicionarAula(aula);
    }

    public void removerAula(int aulaId) {
        aulaDAO.removerAula(aulaId);
    }

    public Aula buscarAulaPorId(int aulaId) {
        return aulaDAO.buscarAulaPorId(aulaId);
    }

    public List<Aula> listarAulas() {
        return aulaDAO.listarAulas();
    }

    public boolean adicionarAlunoNaAula(int aulaId) {
        Aula aula = buscarAulaPorId(aulaId);
        if (aula != null && aula.getSala().getCapacidade() > aula.getQuantidadeAlunos()) {
            aula.adicionarAluno();
            return true;
        }
        return false;
    }
}