package com.academia.usuario.view;

import com.academia.usuario.controller.UsuarioController;
import com.academia.usuario.model.Administrador;
import com.academia.usuario.model.Usuario;

import java.util.List;
import java.util.Scanner;

public class UsuarioConsoleView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UsuarioController usuarioController = new UsuarioController();

    public static void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- Gestão de Usuários ---");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Atualizar Usuário");
            System.out.println("3. Remover Usuário");
            System.out.println("4. Buscar Usuário por ID");
            System.out.println("5. Listar Todos os Usuários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> adicionarUsuario();
                case 2 -> atualizarUsuario();
                case 3 -> removerUsuario();
                case 4 -> buscarUsuarioPorId();
                case 5 -> listarUsuarios();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void adicionarUsuario() {
        System.out.print("Nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Email do Usuário: ");
        String email = scanner.nextLine();
        System.out.print("Senha do Usuário: ");
        String senha = scanner.nextLine();
        System.out.print("Este usuário é administrador? (s/n): ");
        String isAdmin = scanner.nextLine();

        Usuario usuario;
        if (isAdmin.equalsIgnoreCase("s")) {
            usuario = new Administrador(0, nome, email, senha);
        } else {
            usuario = new Usuario(0, nome, email, senha);
        }

        usuarioController.adicionarUsuario(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private static void atualizarUsuario() {
        System.out.print("ID do Usuário a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Novo Nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Email do Usuário: ");
        String email = scanner.nextLine();
        System.out.print("Nova Senha do Usuário: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(id, nome, email, senha);
        usuarioController.atualizarUsuario(usuario);
        System.out.println("Usuário atualizado com sucesso!");
    }

    private static void removerUsuario() {
        System.out.print("ID do Usuário a ser removido: ");
        int id = scanner.nextInt();
        usuarioController.removerUsuario(id);
        System.out.println("Usuário removido com sucesso!");
    }

    private static void buscarUsuarioPorId() {
        System.out.print("ID do Usuário: ");
        int id = scanner.nextInt();
        Usuario usuario = usuarioController.buscarUsuarioPorId(id);
        if (usuario != null) {
            System.out.println(usuario);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private static void listarUsuarios() {
        List<Usuario> usuarios = usuarioController.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }
}
