package com.academia.sala.dao;

import com.academia.sala.model.Sala;
import com.academia.storage.StorageJSON;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de acesso a dados (DAO) para Sala em JSON.
 */
public class SalaDAOJSON implements SalaDAO {
    private final StorageJSON<Sala> storage;

    /**
     * Construtor da classe.
     */
    public SalaDAOJSON() {
        Type salaListType = new TypeToken<List<Sala>>() {}.getType();
        this.storage = new StorageJSON<>(salaListType, "salas.json");
    }

    /**
     * Método para adicionar uma sala.
     *
     * @param sala Sala a ser adicionada.
     */
    @Override
    public void adicionarSala(Sala sala) {
        List<Sala> salas = storage.load();
        if (salas == null) {
            salas = new ArrayList<>();
        }

        int newId = salas.stream().mapToInt(Sala::getId).max().orElse(0) + 1;
        sala.setId(newId);
        salas.add(sala);
        storage.save(salas);
    }

    /**
     * Método para remover uma sala por ID.
     *
     * @param id ID da sala a ser removida.
     * @return boolean
     */
    @Override
    public boolean removerSala(int id) {
        List<Sala> salas = storage.load();
        if (salas != null) {
            salas = salas.stream()
                    .filter(sala -> sala.getId() != id)
                    .collect(Collectors.toList());
            storage.save(salas);
            return true;
        }
        return false;
    }

    /**
     * Método para atualizar os dados de uma sala.
     *
     * @param sala Sala a ser atualizada.
     * @return boolean true se a sala foi atualizada, false caso contrário.
     */
    @Override
    public boolean atualizarSala(Sala sala) {
        List<Sala> salas = storage.load();
        if (salas != null) {
            for (int i = 0; i < salas.size(); i++) {
                if (salas.get(i).getId() == sala.getId()) {
                    salas.set(i, sala);
                    storage.save(salas);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método para buscar uma sala por ID.
     *
     * @param id ID da sala a ser buscada.
     * @return Sala encontrada.
     */
    @Override
    public Sala buscarSalaPorId(int id) {
        List<Sala> salas = storage.load();
        if (salas != null) {
            for (Sala sala : salas) {
                if (sala.getId() == id) {
                    return sala;
                }
            }
        }
        return null;
    }

    /**
     * Método para listar todas as salas.
     *
     * @return Lista de salas.
     */
    @Override
    public List<Sala> listarSalas() {
        List<Sala> salas = storage.load();
        return salas != null ? new ArrayList<>(salas) : new ArrayList<>();
    }
}
