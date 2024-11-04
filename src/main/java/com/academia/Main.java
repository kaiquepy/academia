package com.academia;

import com.academia.cliente.controller.ClienteController;
import com.academia.cliente.dao.ClienteDAO;
import com.academia.cliente.dao.ClienteDAOMySQL;
import com.academia.cliente.view.console.ClienteConsoleView;


public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAOMySQL();
        ClienteController clienteController = new ClienteController(clienteDAO);

        ClienteConsoleView.exibirMenu(clienteController);
    }
}