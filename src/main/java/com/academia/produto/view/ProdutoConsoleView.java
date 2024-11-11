package com.academia.produto.view;

import com.academia.produto.controller.ProdutoController;
import com.academia.produto.model.Produto;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de serviço para Produto.
 */
public class ProdutoConsoleView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProdutoController produtoController = new ProdutoController();

    /**
     * Método para exibir o menu de opções.
     */
    public static void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- Gestão de Produtos ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Buscar Produto por ID");
            System.out.println("5. Listar Todos os Produtos");
            System.out.println("6. Produtos instanciados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> atualizarProduto();
                case 3 -> removerProduto();
                case 4 -> buscarProdutoPorId();
                case 5 -> listarProdutos();
                case 6 -> produtosInstanciados();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Método para adicionar um produto.
     */
    private static void adicionarProduto() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Categoria do Produto: ");
        String categoria = scanner.nextLine();

        Produto produto = new Produto(0, nome, preco, categoria);
        produtoController.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    /**
     * Método para atualizar um produto.
     */
    private static void atualizarProduto() {
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Novo Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Preço do Produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Nova Categoria do Produto: ");
        String categoria = scanner.nextLine();

        Produto produto = new Produto(produtoId, nome, preco, categoria);
        produtoController.atualizarProduto(produto);
        System.out.println("Produto atualizado com sucesso!");
    }

    /**
     * Método para remover um produto.
     */
    private static void removerProduto() {
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        produtoController.removerProduto(produtoId);
        System.out.println("Produto removido com sucesso!");
    }

    /**
     * Método para buscar um produto por ID.
     */
    private static void buscarProdutoPorId() {
        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        Produto produto = produtoController.buscarProdutoPorId(produtoId);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    /**
     * Método para listar todos os produtos.
     */
    private static void listarProdutos() {
        List<Produto> produtos = produtoController.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    private static void produtosInstanciados() {
        System.out.println("Produtos instanciados: " + Produto.getContadorInstancias());
    }

    /**
     * Sobreposição do método toString para retornar qual controller está sendo utilizado.
     *
     * @return String com o controller de produto.
     */
    @Override
    public String toString() {
        return "ProdutoConsoleView{" +
                "produtoController=" + produtoController +
                '}';
    }
}
