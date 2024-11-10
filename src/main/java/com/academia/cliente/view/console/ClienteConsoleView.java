package com.academia.cliente.view.console;

import com.academia.cliente.controller.ClienteController;
import com.academia.cliente.model.Cliente;

import java.util.Scanner;

/**
 * Classe ClienteConsoleView representa a camada de visão de clientes.
 *
 * Esta classe é responsável por exibir um menu de opções para interação com o usuário.
 */
public class ClienteConsoleView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ClienteController clienteController = new ClienteController();

    /**
     * Exibe um menu de opções para interação com o usuário.
     */
    public static void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- Gestão de Clientes ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Buscar Cliente");
            System.out.println("5. Listar Clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> adicionarCliente();
                case 2 -> atualizarCliente();
                case 3 -> removerCliente();
                case 4 -> buscarCliente();
                case 5 -> clienteController.listarClientes();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Adiciona um novo cliente.
     */
    public static void adicionarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Cliente novoCliente = new Cliente(0, nome, cpf, endereco, telefone, email);
        clienteController.cadastrarCliente(novoCliente);
    }

    /**
     * Atualiza um cliente existente.
     */
    public static void atualizarCliente() {
        System.out.print("ID do cliente a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Cliente clienteAtualizado = clienteController.buscarCliente(id);

        if (clienteAtualizado != null) {
            System.out.print("Novo Nome: ");
            clienteAtualizado.setNome(scanner.nextLine());
            System.out.print("Novo Endereço: ");
            clienteAtualizado.setEndereco(scanner.nextLine());
            System.out.print("Novo Telefone: ");
            clienteAtualizado.setTelefone(scanner.nextLine());
            System.out.print("Novo Email: ");
            clienteAtualizado.setEmail(scanner.nextLine());
            clienteController.atualizarCliente(clienteAtualizado);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    /**
     * Remove um cliente existente.
     */
    public static void removerCliente() {
        System.out.print("ID do cliente a ser removido: ");
        int id = scanner.nextInt();

        clienteController.removerCliente(id);
    }

    /**
     * Busca um cliente pelo ID.
     */
    public static void buscarCliente() {
        System.out.print("Id do cliente: ");
        int id = scanner.nextInt();

        Cliente cliente = clienteController.buscarCliente(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}
