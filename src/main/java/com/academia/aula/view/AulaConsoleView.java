package com.academia.aula.view;

import com.academia.aula.controller.AulaController;
import com.academia.aula.model.Aula;
import com.academia.funcionario.controller.FuncionarioController;
import com.academia.funcionario.model.Funcionario;
import com.academia.sala.controller.SalaController;
import com.academia.sala.model.Sala;

import java.util.List;
import java.util.Scanner;

public class AulaConsoleView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AulaController aulaController = new AulaController();
    private static final SalaController salaController = new SalaController();
    private static final FuncionarioController funcionarioController = new FuncionarioController();

    public static void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Gestão de Aulas ---");
            System.out.println("1. Adicionar Aula");
            System.out.println("2. Remover Aula");
            System.out.println("3. Buscar Aula por ID");
            System.out.println("4. Listar Todas as Aulas");
            System.out.println("5. Adicionar Aluno na Aula");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> adicionarAula();
                case 2 -> removerAula();
                case 3 -> buscarAulaPorId();
                case 4 -> listarAulas();
                case 5 -> adicionarAlunoNaAula();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void adicionarAula() {
        System.out.print("Nome da Aula: ");
        String nome = scanner.nextLine();
        System.out.print("ID da Sala: ");
        int salaId = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        Sala sala = salaController.buscarSalaPorId(salaId);
        if (sala == null) {
            System.out.println("Sala não encontrada.");
            return;
        }
        System.out.print("ID do Professor: ");
        int professorId = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        Funcionario professor = funcionarioController.buscarFuncionario(professorId);
        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }
        System.out.print("Data e Hora (AAAA-MM-DDTHH:MM): ");
        String dataHora = scanner.nextLine();
        System.out.print("Valor da Aula: ");
        double valor = scanner.nextDouble();

        Aula aula = new Aula(0, nome, sala, dataHora, valor, professor);
        aulaController.adicionarAula(aula);
        System.out.println("Aula adicionada com sucesso!");
    }

    private static void removerAula() {
        System.out.print("ID da Aula a ser removida: ");
        int id = scanner.nextInt();
        aulaController.removerAula(id);
        System.out.println("Aula removida com sucesso!");
    }

    private static void buscarAulaPorId() {
        System.out.print("ID da Aula: ");
        int id = scanner.nextInt();
        Aula aula = aulaController.buscarAulaPorId(id);
        if (aula != null) {
            System.out.println(aula);
        } else {
            System.out.println("Aula não encontrada.");
        }
    }

    private static void listarAulas() {
        List<Aula> aulas = aulaController.listarAulas();
        if (aulas.isEmpty()) {
            System.out.println("Nenhuma aula encontrada.");
        } else {
            aulas.forEach(System.out::println);
        }
    }

    private static void adicionarAlunoNaAula() {
        System.out.print("ID da Aula: ");
        int aulaId = scanner.nextInt();
        boolean sucesso = aulaController.adicionarAlunoNaAula(aulaId);
        if (sucesso) {
            System.out.println("Aluno adicionado com sucesso na aula!");
        } else {
            System.out.println("Não foi possível adicionar aluno. Capacidade máxima atingida ou aula não encontrada.");
        }
    }
}
