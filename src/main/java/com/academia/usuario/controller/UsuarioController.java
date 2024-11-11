package com.academia.usuario.controller;

import com.academia.usuario.model.Usuario;
import com.academia.usuario.service.UsuarioService;

import java.util.List;

public class UsuarioController {
    private final UsuarioService usuarioService = new UsuarioService();

    public void adicionarUsuario(Usuario usuario) {
        usuarioService.adicionarUsuario(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioService.atualizarUsuario(usuario);
    }

    public void removerUsuario(int usuarioId) {
        usuarioService.removerUsuario(usuarioId);
    }

    public Usuario buscarUsuarioPorId(int usuarioId) {
        return usuarioService.buscarUsuarioPorId(usuarioId);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
}
