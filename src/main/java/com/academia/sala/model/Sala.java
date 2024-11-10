package com.academia.sala.model;

/**
 * Classe para representar uma Sala.
 */
public class Sala {
    private int id;
    private String nome;
    private int capacidade;

    /**
     * Construtor da classe.
     *
     * @param id         ID da sala.
     * @param nome       Nome da sala.
     * @param capacidade Capacidade da sala.
     */
    public Sala(int id, String nome, int capacidade) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    // region Getters and Setters
    /**
     * Método para obter o ID da sala.
     *
     * @return ID da sala.
     */
    public int getId() {
        return id;
    }

    /**
     * Método para definir o ID da sala.
     *
     * @param id ID da sala.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método para obter o nome da sala.
     *
     * @return Nome da sala.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para definir o nome da sala.
     *
     * @param nome Nome da sala.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para obter a capacidade da sala.
     *
     * @return Capacidade da sala.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Método para definir a capacidade da sala.
     *
     * @param capacidade Capacidade da sala.
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    // endregion

    /**
     * Sobrescrita do método toString para retornar o ID, nome e capacidade da sala.
     *
     * @return ID, nome e capacidade da sala.
     */
    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}
