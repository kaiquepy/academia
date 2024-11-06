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

    /**
     * Exibe um menu de opções para interação com o usuário.
     *
     * @param funcionarioController Controller de funcionário.
     */
    public static void exibirMenu(FuncionarioController funcionarioController) {
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
                case 1:
                    adicionarFuncionario(funcionarioController);
                    break;
                case 2:
                    atualizarFuncionario(funcionarioController);
                    break;
                case 3:
                    removerFuncionario(funcionarioController);
                    break;
                case 4:
                    buscarFuncionarioPorId(funcionarioController);
                    break;
                case 5:
                    listarFuncionarios(funcionarioController);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    /**
     * Adiciona um novo funcionário.
     *
     * @param funcionarioController Controller de funcionário.
     */
    private static void adicionarFuncionario(FuncionarioController funcionarioController) {
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
     *
     * @param funcionarioController Controller de funcionário.
     */
    private static void buscarFuncionarioPorId(FuncionarioController funcionarioController) {
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
     *
     * @param funcionarioController Controller de funcionário.
     */
    private static void listarFuncionarios(FuncionarioController funcionarioController) {
        ArrayList<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado.");
        } else {
            System.out.println("--- Lista de Funcionários ---");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome() + ", Cargo: " + funcionario.getCargo() + ", Salário: " + funcionario.getSalario());
            }
        }
    }

    /**
     * Atualiza um funcionário existente.
     *
     * @param funcionarioController Controller de funcionário.
     */
    private static void atualizarFuncionario(FuncionarioController funcionarioController) {
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
     *
     * @param funcionarioController Controller de funcionário.
     */
    private static void removerFuncionario(FuncionarioController funcionarioController) {
        System.out.print("ID do Funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        funcionarioController.removerFuncionario(id);
        System.out.println("Funcionário removido com sucesso!");
    }
}
