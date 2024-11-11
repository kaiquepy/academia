package com.academia.aula.controller;

import com.academia.aula.model.Aula;
import com.academia.aula.service.AulaService;

import java.util.List;

public class AulaController {
    private final AulaService aulaService = new AulaService();

    public void adicionarAula(Aula aula) {
        aulaService.adicionarAula(aula);
    }

    public void removerAula(int aulaId) {
        aulaService.removerAula(aulaId);
    }

    public Aula buscarAulaPorId(int aulaId) {
        return aulaService.buscarAulaPorId(aulaId);
    }

    public List<Aula> listarAulas() {
        return aulaService.listarAulas();
    }

    public boolean adicionarAlunoNaAula(int aulaId) {
        return aulaService.adicionarAlunoNaAula(aulaId);
    }
}