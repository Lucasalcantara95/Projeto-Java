package com.exemplo.webapi.controller;

import com.exemplo.webapi.model.Usuario;
import com.exemplo.webapi.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarTodos();
    }

    @PostMapping
    public void adicionarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.adicionar(usuario);
    }
}
