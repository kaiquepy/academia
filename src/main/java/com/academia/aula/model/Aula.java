package com.academia.aula.model;

import com.academia.funcionario.model.Funcionario;
import com.academia.sala.model.Sala;

import java.time.LocalDateTime;

public class Aula {
    private int id;
    private String nome;
    private Sala sala;
    private String dataHora;
    private double valor;
    private int quantidadeAlunos;
    private Funcionario professor;

    public Aula(int id, String nome, Sala sala, String dataHora, double valor, Funcionario professor) {
        this.id = id;
        this.nome = nome;
        this.sala = sala;
        this.dataHora = dataHora;
        this.valor = valor;
        this.quantidadeAlunos = 0;
        this.professor = professor;
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

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDateTime getDataHora() {
        return LocalDateTime.parse(this.dataHora);
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora.toString();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public void adicionarAluno() {
        this.quantidadeAlunos++;
    }

    public Funcionario getProfessor() {
        return professor;
    }

    public void setProfessor(Funcionario professor) {
        this.professor = professor;
    }
    // endregion

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sala=" + sala +
                ", dataHora=" + dataHora +
                ", valor=" + valor +
                ", quantidadeAlunos=" + quantidadeAlunos +
                ", professor=" + professor +
                '}';
    }
}