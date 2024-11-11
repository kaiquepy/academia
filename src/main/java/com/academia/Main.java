package com.academia;

import com.academia.cliente.model.Cliente;
import com.academia.dashboard.view.console.DashboardConsoleView;
import com.academia.utils.Config;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        menu();
        try {
            Properties properties = Config.getProperties();
            if (properties.getProperty("view.type").equals("console")) {
                DashboardConsoleView.exibirMenu();
            } else {
                System.out.println("Tipo de visualização não suportado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar o sistema: " + e.getMessage());
        }
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "João", "123.456.789-00", "Rua A", "99999-0000", "joao@example.com"));
        clientes.add(new Cliente(2, "Maria", "987.654.321-00", "Rua B", "88888-1111", "maria@example.com"));
        clientes.add(new Cliente(3, "Ana", "123.123.123-00", "Rua C", "77777-2222", "ana@example.com"));

        System.out.println("Questões:");
        System.out.println("1. Questão 15");
        System.out.println("2. Questão 16");
        System.out.println("3. Questão 17");

        int opcao;
        do {
            System.out.print("Escolha uma questão (0 para sair): ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> questao15(clientes);
                case 2 -> questao16(clientes);
                case 3 -> questao17(clientes);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Questão 15: Iterar sobre a lista de clientes usando Iterator e Foreach.
     */
    public static void questao15(List<Cliente> clientes) {
        System.out.println("Questão 15: Uso de Iterator e Foreach");

        // Iterando com Iterator
        Iterator<Cliente> iterator = clientes.iterator();
        System.out.println("Iterando com Iterator:");
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            System.out.println(cliente);
        }

        // Iterando com Foreach
        System.out.println("\nIterando com Foreach:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Questão 16: Testar Comparator e usar Collections.sort() para ordenar a lista de clientes.
     */
    public static void questao16(List<Cliente> clientes) {
        System.out.println("\nQuestão 16: Uso de Comparator para Ordenação");

        // Comparator para ordenar por nome
        Comparator<Cliente> nomeComparator = Comparator.comparing(Cliente::getNome);
        Collections.sort(clientes, nomeComparator);
        System.out.println("Ordenando por Nome:");
        clientes.forEach(System.out::println);

        // Comparator para ordenar por CPF
        Comparator<Cliente> cpfComparator = Comparator.comparing(Cliente::getCpf);
        Collections.sort(clientes, cpfComparator);
        System.out.println("\nOrdenando por CPF:");
        clientes.forEach(System.out::println);
    }

    /**
     * Questão 17: Implementar método find usando Iterator e Comparator, e comparar com binarySearch.
     */
    public static void questao17(List<Cliente> clientes) {
        System.out.println("\nQuestão 17: Método Find e BinarySearch");

        // Ordenar a lista por CPF antes de usar binarySearch
        Comparator<Cliente> cpfComparator = Comparator.comparing(Cliente::getCpf);
        Collections.sort(clientes, cpfComparator);

        // Cliente para buscar
        Cliente target = new Cliente(0, "", "123.123.123-00", "", "", "");

        // Buscar com método find
        Cliente foundCliente = findCliente(clientes, cpfComparator, target);
        System.out.println("Resultado do método find:");
        System.out.println(foundCliente);

        // Buscar com Collections.binarySearch
        int index = Collections.binarySearch(clientes, target, cpfComparator);
        Cliente foundBinarySearch = (index >= 0) ? clientes.get(index) : null;
        System.out.println("\nResultado do binarySearch:");
        System.out.println(foundBinarySearch);
    }

    /**
     * Método find para buscar um cliente usando Iterator e Comparator.
     *
     * @param clientes   Lista de clientes.
     * @param comparator Comparador para determinar igualdade.
     * @param target     Cliente alvo.
     * @return Cliente encontrado ou null se não encontrado.
     */
    public static Cliente findCliente(List<Cliente> clientes, Comparator<Cliente> comparator, Cliente target) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (comparator.compare(cliente, target) == 0) {
                return cliente;
            }
        }
        return null;
    }
}