package com.academia.cliente.model;


/**
 * A classe Cliente representa uma entidade com informações básicas de um cliente.
 * Ela possui atributos como nome, CPF, endereço, telefone e e-mail.
 */
public class Cliente {
    protected static int contadorInstanciasProtected = 0;
    private static int contadorInstanciasPrivate = 0;

    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

    /**
     * Construtor da classe Cliente.
     *
     * @param id       Identificador do cliente.
     * @param nome     Nome do cliente.
     * @param cpf      Cadastro de pessoa física do cliente.
     * @param endereco Endereço do cliente.
     * @param telefone Telefone do cliente.
     * @param email    E-mail do cliente.
     */
    public Cliente(int id, String nome, String cpf, String endereco, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        contadorInstanciasProtected++;
        incrementarContadorInstanciasPrivate();
    }

    public static int getContadorInstanciasProtected() {
        return contadorInstanciasProtected;
    }

    private static void incrementarContadorInstanciasPrivate() {
        contadorInstanciasPrivate++;
    }

    public static int getContadorInstanciasPrivate() {
        return contadorInstanciasPrivate;
    }

    // region Getters and Setters
    /**
     * Retorna o identificador do cliente.
     *
     * @return int Id do cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do cliente.
     *
     * @param id Identificador do cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do cliente.
     *
     * @return String Nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     *
     * @param nome Nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o CPF do cliente.
     *
     * @return String CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     *
     * @param cpf CPF do cliente.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o endereço do cliente.
     *
     * @return String Endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param endereco Endereço do cliente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o telefone do cliente.
     *
     * @return String Telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     *
     * @param telefone Telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o e-mail do cliente.
     *
     * @return String E-mail do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do cliente.
     *
     * @param email E-mail do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    // endregion

    /**
     * Retorna a representação em String do objeto Cliente.
     *
     * @return String representando o objeto.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id + '\'' +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
