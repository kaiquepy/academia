package com.academia.cliente.dao;

import com.academia.cliente.model.Cliente;
import com.academia.storage.StorageMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da interface ClienteDAO para persistência de dados em MySQL.
 */
public class ClienteDAOMySQL implements ClienteDAO {
    /**
     * Adiciona um novo cliente.
     *
     * @param cliente Cliente a ser adicionado.
     */
    @Override
    public void adicionarCliente(Cliente cliente) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "INSERT INTO clientes (nome, cpf, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.executeUpdate();
            System.out.println("Cliente salvo no MySQL: " + cliente.getNome());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar cliente no MySQL", e);
        }
    }

    /**
     * Remove um cliente pelo CPF.
     *
     * @param id Identificador do cliente.
     */
    @Override
    public void removerCliente(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente deletado do MySQL com Id: " + id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover cliente do MySQL", e);
        }
    }

    /**
     * Atualiza os dados de um cliente.
     *
     * @param cliente Cliente a ser atualizado.
     */
    @Override
    public void atualizarCliente(Cliente cliente) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ?, email = ? WHERE cpf = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCpf());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado no MySQL: " + cliente.getNome());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cliente no MySQL", e);
        }
    }

    /**
     * Busca um cliente pelo CPF.
     *
     * @param id Identificador do cliente.
     * @return Cliente
     */
    @Override
    public Cliente buscarClientePorId(int id) {
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cliente no MySQL", e);
        }
        System.out.println("Cliente não encontrado no MySQL com Id: " + id);
        return null;
    }

    /**
     * Lista todos os clientes cadastrados.
     *
     * @return List<> de clientes.
     */
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = StorageMySQL.getConnection()) {
            String sql = "SELECT * FROM clientes";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar clientes do MySQL", e);
        }
        System.out.println("Listando clientes do MySQL");
        return clientes;
    }

    /**
     * Retorna a representação em String do objeto.
     *
     * @return String representando o objeto.
     */
    @Override
    public String toString() {
        return "Dao (Data Access Object) de Cliente em MySQL";
    }
}
