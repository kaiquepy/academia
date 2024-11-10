package com.academia.venda.model;

import com.academia.produto.model.Produto;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe para representar uma Venda.
 */
public class Venda {
    private int id;
    private List<Produto> produtos;
    private double valorTotal;
    private LocalDate dataVenda;

    /**
     * Construtor da classe.
     *
     * @param id        ID da venda.
     * @param produtos  Lista de produtos da venda.
     * @param valorTotal Valor total da venda.
     * @param dataVenda  Data da venda.
     */
    public Venda(int id, List<Produto> produtos, double valorTotal, LocalDate dataVenda) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    // region Getters and Setters
    /**
     * Método para obter o ID da venda.
     *
     * @return ID da venda.
     */
    public int getId() {
        return id;
    }

    /**
     * Método para definir o ID da venda.
     *
     * @param id ID da venda.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método para obter a lista de produtos da venda.
     *
     * @return Lista de produtos da venda.
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Método para definir a lista de produtos da venda.
     *
     * @param produtos Lista de produtos da venda.
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * Método para obter o valor total da venda.
     *
     * @return Valor total da venda.
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Método para definir o valor total da venda.
     *
     * @param valorTotal Valor total da venda.
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Método para obter a data da venda.
     *
     * @return Data da venda.
     */
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    /**
     * Método para definir a data da venda.
     *
     * @param dataVenda Data da venda.
     */
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    // endregion

    /**
     * Sobrescreve o método toString para os atributos da classe.
     *
     * @return Atributos da classe.
     */
    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", produtos=" + produtos +
                ", valorTotal=" + valorTotal +
                ", dataVenda=" + dataVenda +
                '}';
    }
}
