package com.academia.venda.model;

import com.academia.produto.model.Produto;

import java.time.LocalDate;
import java.util.List;

public class Venda {
    private int id;
    private List<Produto> produtos;
    private double valorTotal;
    private LocalDate dataVenda;

    public Venda(int id, List<Produto> produtos, double valorTotal, LocalDate dataVenda) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    // region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    // endregion

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
