package com.academia.produto.model;

/**
 * Classe que representa um Produto.
 */
public class Produto {
    private static int contadorInstancias = 0;

    private int id;
    private String nome;
    private double preco;
    private String categoria;

    /**
     * Construtor da classe.
     *
     * @param id identificador do Produto.
     * @param nome do Produto.
     * @param preco do Produto.
     * @param categoria do Produto.
     */
    public Produto(int id, String nome, double preco, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        incrementarContadorInstancias();
    }

    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    private static void incrementarContadorInstancias() {
        contadorInstancias++;
    }

    // region Getters and Setter
    /**
     * Método para obter o ID do Produto.
     *
     * @return int ID do Produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Método para definir o ID do Produto.
     *
     * @param id ID do Produto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método para obter o Nome do Produto.
     *
     * @return String Nome do Produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para definir o Nome do Produto.
     *
     * @param nome Nome do Produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para obter o Preço do Produto.
     *
     * @return double Preço do Produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Método para definir o Preço do Produto.
     *
     * @param preco Preço do Produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Método para obter a Categoria do Produto.
     *
     * @return String Categoria do Produto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Método para definir a Categoria do Produto.
     *
     * @param categoria Categoria do Produto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    // endregion

    /**
     * Método para exibir o Produto como String.
     *
     * return String com os dados do Produto.
     */
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
