package com.academia.dashboard.view.console;

import com.academia.cliente.view.console.ClienteConsoleView;
import com.academia.funcionario.view.console.FuncionarioConsoleView;

import java.util.Scanner;

public class DashboardConsoleView {
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        do {
            System.out.println("\n===== Dashboard Principal =====");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Loja");
            System.out.println("4. Gerenciar Equipamentos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolhaMenu = scanner.nextInt();

            switch (escolhaMenu) {
                case 1:
                    ClienteConsoleView.exibirMenu();
                    break;
                case 2:
                    FuncionarioConsoleView.exibirMenu();
                    break;
                case 3:
                    System.out.println("Módulo Loja ainda não implementado.");
                    break;
                case 4:
                    System.out.println("Módulo Equipamentos ainda não implementado.");
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (continuar);
        scanner.close();
    }
}
