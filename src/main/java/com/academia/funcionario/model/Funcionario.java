package com.academia.funcionario.model;


/**
 * A classe Funcionário representa uma entidade com informações básicas de um funcionário.
 * Ela possui atributos como nome, cargo e salário.
 */
public class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private double salario;

    /**
     * Construtor da classe Funcionário.
     *
     * @param id      Identificador do funcionário.
     * @param nome    Nome do funcionário.
     * @param cargo   Cargo do funcionário.
     * @param salario Salário do funcionário.
     */
    public Funcionario(int id, String nome, String cargo, double salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    // region Getters and Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    // endregion

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
