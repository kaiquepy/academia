package com.academia.aula.dao;

import com.academia.aula.model.Aula;

import java.util.List;

public interface AulaDAO {
    void adicionarAula(Aula aula);
    void removerAula(int aulaId);
    Aula buscarAulaPorId(int aulaId);
    void atualizarAula(Aula aula);
    List<Aula> listarAulas();
}