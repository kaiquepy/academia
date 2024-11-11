package com.academia.usuario.service;

import com.academia.usuario.dao.UsuarioDAO;
import com.academia.usuario.dao.UsuarioDAOJSON;
import com.academia.usuario.dao.UsuarioDAOMySQL;
import com.academia.usuario.model.Usuario;
import com.academia.utils.Config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        try {
            Properties config = Config.getProperties();

            if (config.getProperty("storage.type").equals("json")) {
                this.usuarioDAO = new UsuarioDAOJSON();
            } else {
                this.usuarioDAO = new UsuarioDAOMySQL();
            }
        } catch (
        IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de configuração.");
        }
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarioDAO.adicionarUsuario(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioDAO.atualizarUsuario(usuario);
    }

    public void removerUsuario(int usuarioId) {
        usuarioDAO.removerUsuario(usuarioId);
    }

    public Usuario buscarUsuarioPorId(int usuarioId) {
        return usuarioDAO.buscarUsuarioPorId(usuarioId);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }
}
