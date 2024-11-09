package com.academia;

import com.academia.dashboard.view.console.DashboardConsoleView;
import com.academia.utils.Config;

import java.util.Properties;


public class Main {
    public static void main(String[] args) {
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
}