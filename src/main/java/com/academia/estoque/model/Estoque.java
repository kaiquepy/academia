package com.academia.estoque.model;

public class Estoque {
    private int produtoId;
    private int quantidade;

    public Estoque(int produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    // region Getters and Setters
    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    // endregion

    @Override
    public String toString() {
        return "Estoque{" +
                "produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                '}';
    }
}
