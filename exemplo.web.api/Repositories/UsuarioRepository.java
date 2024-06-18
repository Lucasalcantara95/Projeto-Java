package com.exemplo.webapi.repository;

import com.exemplo.webapi.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }
}
