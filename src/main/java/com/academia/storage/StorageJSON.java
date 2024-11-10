package com.academia.storage;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/*
 * Classe para manipulação de arquivos JSON.
 *
 * @param <T> Tipo de objeto a ser manipulado.
 */
public class StorageJSON<T> {
    private static StorageJSON instance;
    private final String FILE_PATH;
    private final Gson gson;
    private final Type type;

    /*
     * Construtor privado para garantir que a classe seja um singleton.
     *
     * @param type Tipo de objeto a ser manipulado.
     */
    public StorageJSON(Type type, String filePath) {
        this.gson = new Gson();
        this.type = type;
        this.FILE_PATH = filePath;
    }

    /*
     * Método para salvar a lista de objetos no arquivo JSON.
     *
     * @param data Lista de objetos a ser salva.
     */
    public void save(List<T> data) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar os dados no arquivo JSON: " + e.getMessage());
        }
    }

    /*
     * Método para carregar a lista de objetos do arquivo JSON.
     *
     * @return Lista de objetos carregada.
     */
    public List<T> load() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar os dados do arquivo JSON: " + e.getMessage());
        }
    }

    /*
     * Sobrescreve o método toString para retornar uma descrição da classe.
     *
     * @return Descrição da classe.
     */
    @Override
    public String toString() {
        return "Classe para manipulação de arquivos JSON.";
    }
}
