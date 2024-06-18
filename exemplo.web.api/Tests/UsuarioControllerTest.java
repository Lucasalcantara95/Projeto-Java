package com.exemplo.webapi.controller;

import com.exemplo.webapi.model.Usuario;
import com.exemplo.webapi.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepository usuarioRepository;

    private List<Usuario> usuarios;

    @BeforeEach
    void setUp() {
        usuarios = Arrays.asList(
                new Usuario(1L, "João Silva", "joao.silva@example.com", "senha123"),
                new Usuario(2L, "Maria Oliveira", "maria.oliveira@example.com", "senha456")
        );

        when(usuarioRepository.listarTodos()).thenReturn(usuarios);
    }

    @Test
    void listarUsuariosTest() throws Exception {
        mockMvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("João Silva"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nome").value("Maria Oliveira"));
    }

    @Test
    void adicionarUsuarioTest() throws Exception {
        String usuarioJson = "{ \"id\": 3, \"nome\": \"Pedro Souza\", \"email\": \"pedro.souza@example.com\", \"senha\": \"senha789\" }";

        mockMvc.perform(post("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuarioJson))
                .andExpect(status().isOk());
    }
}
