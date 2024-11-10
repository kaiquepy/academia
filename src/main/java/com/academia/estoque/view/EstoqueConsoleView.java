package com.academia.estoque.view;

import com.academia.estoque.controller.EstoqueController;

import java.util.Scanner;

public class EstoqueConsoleView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EstoqueController estoqueController = new EstoqueController();

    public static void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- Gestão de Estoque ---");
            System.out.println("1. Adicionar Estoque");
            System.out.println("2. Atualizar Estoque");
            System.out.println("3. Remover Estoque");
            System.out.println("4. Buscar Quantidade de Produto por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> adicionarEstoque();
                case 2 -> atualizarEstoque();
                case 3 -> removerEstoque();
                case 4 -> buscarQuantidadePorProdutoId();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void adicionarEstoque() {
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        estoqueController.adicionarEstoque(produtoId, quantidade);
        System.out.println("Estoque adicionado com sucesso!");
    }

    private static void atualizarEstoque() {
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        System.out.print("Nova Quantidade: ");
        int quantidade = scanner.nextInt();
        estoqueController.atualizarEstoque(produtoId, quantidade);
        System.out.println("Estoque atualizado com sucesso!");
    }

    private static void removerEstoque() {
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        estoqueController.removerEstoque(produtoId);
        System.out.println("Estoque removido com sucesso!");
    }

    private static void buscarQuantidadePorProdutoId() {
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        int quantidade = estoqueController.buscarQuantidadePorProdutoId(produtoId);
        System.out.println("Quantidade disponível: " + quantidade);
    }
}
