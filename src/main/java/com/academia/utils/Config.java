package com.academia.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe para carregar as configurações do sistema.
 */
public class Config {
    /**
     * Método para obter as propriedades do arquivo de configuração.
     *
     * @return Propriedades do arquivo de configuração.
     * @throws IOException Caso ocorra um erro ao carregar o arquivo de configuração.
     */
    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/application.properties");
        properties.load(fileInputStream);
        return properties;
    }

    /**
     * Sobrescreve o método toString para retornar uma descrição da classe.
     *
     * @return Descrição da classe.
     */
    @Override
    public String toString() {
        return "Classe para carregar as configurações do sistema.";
    }
}
