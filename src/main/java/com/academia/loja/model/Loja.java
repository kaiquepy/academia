package com.academia.loja.model;

import com.academia.produto.model.Produto;

import java.util.List;

/**
 * Classe que representa uma Loja.
 */
public class Loja {
    private int id;
    private String nome;
    private List<Produto> produtos;

    /**
     * Construtor da classe.
     *
     * @param id       identificador da Loja.
     * @param nome     da Loja.
     * @param produtos da Loja.
     */
    public Loja(int id, String nome, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    // endregion

    /**
     * Sobrescrita do método toString.
     *
     * @return String com informações da Loja.
     */
    @Override
    public String toString() {
        return "Loja{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", produtos=" + produtos +
                '}';
    }
}
