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
    /**
     * Exibe um menu de opções para interação com o usuário.
     *
     * @param clienteController Controller de cliente.
     */
    public static void exibirMenu(ClienteController clienteController) {
        Scanner scanner = new Scanner(System.in);
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
                case 1:
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
                    Cliente novoCliente = new Cliente(nome, cpf, endereco, telefone, email);
                    clienteController.cadastrarCliente(novoCliente);
                    break;
                case 2:
                    System.out.print("CPF do cliente a ser atualizado: ");
                    cpf = scanner.nextLine();
                    Cliente clienteAtualizado = clienteController.buscarCliente(cpf);
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
                    break;
                case 3:
                    System.out.print("CPF do cliente a ser removido: ");
                    cpf = scanner.nextLine();
                    clienteController.removerCliente(cpf);
                    break;
                case 4:
                    System.out.print("CPF do cliente: ");
                    cpf = scanner.nextLine();
                    Cliente cliente = clienteController.buscarCliente(cpf);
                    if (cliente != null) {
                        System.out.println("Cliente encontrado: " + cliente.getNome());
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;
                case 5:
                    clienteController.listarClientes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
