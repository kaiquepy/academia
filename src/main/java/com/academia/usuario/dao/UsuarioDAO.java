package com.academia.usuario.dao;

import com.academia.usuario.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void adicionarUsuario(Usuario usuario);
    void atualizarUsuario(Usuario usuario);
    void removerUsuario(int usuarioId);
    Usuario buscarUsuarioPorId(int usuarioId);
    Usuario buscarUsuarioPorEmail(String email);
    List<Usuario> listarUsuarios();
}
