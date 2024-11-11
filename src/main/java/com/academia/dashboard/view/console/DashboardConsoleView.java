package com.academia.dashboard.view.console;

import com.academia.aula.view.AulaConsoleView;
import com.academia.cliente.view.console.ClienteConsoleView;
import com.academia.estoque.view.EstoqueConsoleView;
import com.academia.funcionario.view.console.FuncionarioConsoleView;
import com.academia.loja.view.LojaConsoleView;
import com.academia.produto.view.ProdutoConsoleView;
import com.academia.sala.view.console.SalaConsoleView;
import com.academia.usuario.view.UsuarioConsoleView;

import java.util.Scanner;

/**
 * Classe de serviço para o Dashboard.
 */
public class DashboardConsoleView {
    /**
     * Método para exibir o menu principal.
     */
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolhaMenu;

        do {
            System.out.println("\n===== Dashboard Principal =====");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Gerenciar Salas");
            System.out.println("4. Gerenciar Loja");
            System.out.println("5. Gerenciar Produtos");
            System.out.println("6. Gerenciar Estoque");
            System.out.println("7. Gerenciar Usuários");
            System.out.println("8. Gerenciar Aulas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolhaMenu = scanner.nextInt();

            switch (escolhaMenu) {
                case 1 -> ClienteConsoleView.exibirMenu();
                case 2 -> FuncionarioConsoleView.exibirMenu();
                case 3 -> SalaConsoleView.exibirMenu();
                case 4 -> LojaConsoleView.exibirMenu();
                case 5 -> ProdutoConsoleView.exibirMenu();
                case 6 -> EstoqueConsoleView.exibirMenu();
                case 7 -> UsuarioConsoleView.exibirMenu();
                case 8 -> AulaConsoleView.exibirMenu();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolhaMenu != 0);
    }

    /**
     * Sobreposição do método toString para exibir o nome da classe.
     *
     * @return nome da classe.
     */
    @Override
    public String toString() {
        return "Dashboard Console View";
    }
}
