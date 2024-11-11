package com.academia.aula.dao;

import com.academia.aula.model.Aula;
import com.academia.storage.StorageJSON;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AulaDAOJSON implements AulaDAO {
    private final StorageJSON<Aula> storage;

    /**
     * Construtor da classe.
     */
    public AulaDAOJSON() {
        Type aulaListType = new TypeToken<List<Aula>>() {}.getType();
        this.storage = new StorageJSON<>(aulaListType, "aulas.json");
    }

    /**
     * Adiciona uma nova aula.
     *
     * @param aula Aula a ser adicionada.
     */
    @Override
    public void adicionarAula(Aula aula) {
        List<Aula> aulas = storage.load();
        if (aulas == null) {
            aulas = new ArrayList<>();
        }

        int newId = aulas.stream().mapToInt(Aula::getId).max().orElse(0) + 1;
        aula.setId(newId);
        aulas.add(aula);
        storage.save(aulas);
    }

    /**
     * Remove uma aula pelo ID.
     *
     * @param aulaId Identificador da aula.
     */
    @Override
    public void removerAula(int aulaId) {
        List<Aula> aulas = storage.load();
        if (aulas != null) {
            aulas = aulas.stream()
                    .filter(aula -> aula.getId() != aulaId)
                    .collect(Collectors.toList());
            storage.save(aulas);
        }
    }

    /**
     * Atualiza os dados de uma aula.
     *
     * @param aula Aula a ser atualizada.
     */
    @Override
    public void atualizarAula(Aula aula) {
        List<Aula> aulas = storage.load();
        if (aulas != null) {
            for (int i = 0; i < aulas.size(); i++) {
                if (aulas.get(i).getId() == aula.getId()) {
                    aulas.set(i, aula);
                    break;
                }
            }
            storage.save(aulas);
        }
    }

    /**
     * Busca uma aula pelo ID.
     *
     * @param aulaId Identificador da aula.
     * @return Aula ou null se não encontrado.
     */
    @Override
    public Aula buscarAulaPorId(int aulaId) {
        List<Aula> aulas = storage.load();
        if (aulas != null) {
            for (Aula aula : aulas) {
                if (aula.getId() == aulaId) {
                    return aula;
                }
            }
        }
        return null;
    }

    /**
     * Lista todas as aulas cadastradas.
     *
     * @return Lista de aulas.
     */
    @Override
    public List<Aula> listarAulas() {
        List<Aula> aulas = storage.load();
        return aulas != null ? aulas : new ArrayList<>();
    }

    /**
     * Retorna uma representação em String do objeto.
     *
     * @return String representando o objeto.
     */
    @Override
    public String toString() {
        return "AulaDAOJSON{" +
                "storage=" + storage +
                '}';
    }
}
