package com.academia.cliente.model;


/**
 * A classe Cliente representa uma entidade com informações básicas de um cliente.
 * Ela possui atributos como nome, CPF, endereço, telefone e e-mail.
 */
public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

    /**
     * Construtor da classe Cliente.
     *
     * @param nome     Nome do cliente.
     * @param cpf      Cadastro de pessoa física do cliente.
     * @param endereco Endereço do cliente.
     * @param telefone Telefone do cliente.
     * @param email    E-mail do cliente.
     */
    public Cliente(String nome, String cpf, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // region Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // endregion

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
