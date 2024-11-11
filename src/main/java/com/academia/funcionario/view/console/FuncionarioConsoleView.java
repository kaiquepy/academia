package com.academia.funcionario.view.console;

import com.academia.funcionario.controller.FuncionarioController;
import com.academia.funcionario.model.Funcionario;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe FuncionarioConsoleView representa a camada de visão de funcionários.
 *
 * Esta classe é responsável por exibir um menu de opções para interação com o usuário.
 */
public class FuncionarioConsoleView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FuncionarioController funcionarioController = new FuncionarioController();

    /**
     * Exibe um menu de opções para interação com o usuário.
     */
    public static void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- Gestão de Funcionários ---");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Atualizar Funcionário");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Buscar Funcionário");
            System.out.println("5. Listar Funcionários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarFuncionario();
                case 2 -> atualizarFuncionario();
                case 3 -> removerFuncionario();
                case 4 -> buscarFuncionarioPorId();
                case 5 -> listarFuncionarios();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Adiciona um novo funcionário.
     */
    private static void adicionarFuncionario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        Funcionario funcionario = new Funcionario(0, nome, cargo, salario); // ID gerado automaticamente
        funcionarioController.cadastrarFuncionario(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    /**
     * Busca um funcionário por ID.
     */
    private static void buscarFuncionarioPorId() {
        System.out.print("ID do Funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Funcionario funcionario = funcionarioController.buscarFuncionario(id);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado: " + funcionario.getNome() + ", Cargo: " + funcionario.getCargo() + ", Salário: " + funcionario.getSalario());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    /**
     * Lista todos os funcionários cadastrados.
     */
    private static void listarFuncionarios() {
        ArrayList<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado.");
        } else {
            System.out.println("--- Lista de Funcionários ---");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    /**
     * Atualiza um funcionário existente.
     */
    private static void atualizarFuncionario() {
        System.out.print("ID do Funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Novo Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        Funcionario funcionario = new Funcionario(id, nome, cargo, salario);
        funcionarioController.atualizarFuncionario(funcionario);
        System.out.println("Funcionário atualizado com sucesso!");
    }

    /**
     * Remove um funcionário existente.
     */
    private static void removerFuncionario() {
        System.out.print("ID do Funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        funcionarioController.removerFuncionario(id);
        System.out.println("Funcionário removido com sucesso!");
    }

    /**
     * Sobreposição do método toString para retornar qual controller está sendo utilizado.
     *
     * @return String com o controller de funcionário.
     */
    @Override
    public String toString() {
        return "FuncionarioConsoleView{" +
                "funcionarioController=" + funcionarioController +
                '}';
    }
}
