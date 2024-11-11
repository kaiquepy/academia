package com.academia.usuario.dao;

import com.academia.storage.StorageJSON;
import com.academia.usuario.model.Usuario;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDAOJSON implements UsuarioDAO {
    private final StorageJSON<Usuario> storage;
    private List<Usuario> usuarios;

    public UsuarioDAOJSON() {
        Type usuarioListType = new TypeToken<List<Usuario>>() {}.getType();
        this.storage = new StorageJSON<>(usuarioListType, "usuarios.json");
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        List<Usuario> usuarios = storage.load();
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }

        int newId = usuarios.stream().mapToInt(Usuario::getId).max().orElse(0) + 1;
        usuario.setId(newId);
        usuarios.add(usuario);
        storage.save(usuarios);
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                storage.save(usuarios);
                return;
            }
        }
    }

    @Override
    public void removerUsuario(int usuarioId) {
        usuarios = usuarios.stream().filter(usuario -> usuario.getId() != usuarioId).collect(Collectors.toList());
        storage.save(usuarios);
    }

    @Override
    public Usuario buscarUsuarioPorId(int usuarioId) {
        return usuarios.stream().filter(usuario -> usuario.getId() == usuarioId).findFirst().orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarios.stream().filter(usuario -> usuario.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}