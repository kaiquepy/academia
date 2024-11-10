package com.academia.loja.view;

import com.academia.loja.controller.LojaController;
import com.academia.loja.model.Loja;
import com.academia.produto.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaConsoleView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LojaController lojaController = new LojaController();

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Gestão de Loja ---");
            System.out.println("1. Adicionar Loja");
            System.out.println("2. Atualizar Loja");
            System.out.println("3. Remover Loja");
            System.out.println("4. Listar Lojas");
            System.out.println("5. Adicionar Produto à Loja");
            System.out.println("6. Remover Produto da Loja");
            System.out.println("7. Listar Produtos da Loja");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> adicionarLoja();
                case 2 -> atualizarLoja();
                case 3 -> removerLoja();
                case 4 -> listarLojas();
                case 5 -> adicionarProduto();
                case 6 -> removerProduto();
                case 7 -> listarProdutos();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void adicionarLoja() {
        System.out.print("Nome da Loja: ");
        String nome = scanner.nextLine();
        Loja loja = new Loja(0, nome, new ArrayList<>());
        lojaController.adicionarLoja(loja);
        System.out.println("Loja adicionada com sucesso.");
    }

    private static void atualizarLoja() {
        System.out.print("ID da Loja: ");
        int lojaId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo Nome da Loja: ");
        String nome = scanner.nextLine();
        Loja loja = new Loja(lojaId, nome, new ArrayList<>());
        lojaController.atualizarLoja(loja);
        System.out.println("Loja atualizada com sucesso.");
    }

    private static void removerLoja() {
        System.out.print("ID da Loja: ");
        int lojaId = scanner.nextInt();
        lojaController.removerLoja(lojaId);
        System.out.println("Loja removida com sucesso.");
    }

    private static void listarLojas() {
        List<Loja> lojas = lojaController.listarLojas();
        if (lojas.isEmpty()) {
            System.out.println("Nenhuma loja encontrada.");
        } else {
            lojas.forEach(System.out::println);
        }
    }

    private static void adicionarProduto() {
        System.out.print("ID da Loja: ");
        int lojaId = scanner.nextInt();
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        lojaController.adicionarProdutoNaLoja(lojaId, produtoId, quantidade);
        System.out.println("Produto adicionado à loja com sucesso.");
    }

    private static void removerProduto() {
        System.out.print("ID da Loja: ");
        int lojaId = scanner.nextInt();
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        lojaController.removerProdutoDaLoja(lojaId, produtoId);
        System.out.println("Produto removido da loja com sucesso.");
    }

    private static void listarProdutos() {
        System.out.print("ID da Loja: ");
        int lojaId = scanner.nextInt();
        List<Produto> produtos = lojaController.listarProdutosDaLoja(lojaId);
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado na loja.");
        } else {
            produtos.forEach(System.out::println);
        }
    }
}
