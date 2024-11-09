package com.academia.sala.model;

public class Sala {
    private int id;
    private String nome;
    private int capacidade;

    public Sala(int id, String nome, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    // region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    // endregion

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}
