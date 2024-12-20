package com.academia.sala.view.console;

import com.academia.sala.controller.SalaController;
import com.academia.sala.model.Sala;

import java.util.Scanner;

/**
 * Classe para representar a visualização de Salas no console.
 */
public class SalaConsoleView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SalaController salaController = new SalaController();

    /**
     * Método para exibir o menu de Salas no console.
     */
    public static void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- Gestão de Salas ---");
            System.out.println("1. Cadastrar Sala");
            System.out.println("2. Atualizar Sala");
            System.out.println("3. Remover Sala");
            System.out.println("4. Buscar Sala");
            System.out.println("5. Listar Salas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 -> cadastrarSala();
                case 2 -> atualizarSala();
                case 3 -> removerSala();
                case 4 -> buscarSala();
                case 5 -> listarSalas();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Método para cadastrar uma sala.
     */
    private static void cadastrarSala() {
        System.out.print("Digite o nome da sala: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a capacidade da sala: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Sala sala = new Sala(0, nome, capacidade);
        salaController.adicionarSala(sala);
        System.out.println("Sala cadastrada com sucesso!");
    }

    /**
     * Método para atualizar uma sala.
     */
    private static void atualizarSala() {
        System.out.print("Digite o ID da sala a ser atualizada: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Digite o novo nome da sala: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a nova capacidade da sala: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Sala sala = new Sala(id, nome, capacidade);
        if (salaController.atualizarSala(sala)) {
            System.out.println("Sala atualizada com sucesso!");
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    /**
     * Método para remover uma sala.
     */
    private static void removerSala() {
        System.out.print("Digite o ID da sala a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (salaController.removerSala(id)) {
            System.out.println("Sala removida com sucesso!");
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    /**
     * Método para buscar uma sala.
     */
    private static void buscarSala() {
        System.out.print("Digite o ID da sala a ser buscada: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Sala sala = salaController.buscarSalaPorId(id);
        if (sala != null) {
            System.out.println(sala);
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    /**
     * Método para listar todas as salas.
     */
    private static void listarSalas() {
        var salas = salaController.listarSalas();
        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada.");
        } else {
            System.out.println("--- Lista de Salas ---");
            for (Sala sala : salas) {
                System.out.println("ID: " + sala.getId() + ", Nome: " + sala.getNome() + ", Capacidade: " + sala.getCapacidade());
            }
        }
    }

    /**
     * Sobreposição do método toString para retornar qual controller está sendo utilizado.
     *
     * @return String com controller de sala.
     */
    @Override
    public String toString() {
        return "SolaConsoleView{" +
                "salaController=" + salaController +
                '}';
    }
}
