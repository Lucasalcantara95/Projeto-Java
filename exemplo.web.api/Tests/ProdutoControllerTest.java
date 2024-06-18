package com.exemplo.webapi.controller;

import com.exemplo.webapi.model.Produto;
import com.exemplo.webapi.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoRepository produtoRepository;

    private List<Produto> produtos;

    @BeforeEach
    void setUp() {
        produtos = Arrays.asList(
                new Produto(1L, "Geladeira", "Eletrodoméstico", 2500.0),
                new Produto(2L, "Fogão", "Eletrodoméstico", 1200.0),
                new Produto(3L, "Máquina de Lavar", "Eletrodoméstico", 1800.0)
        );

        when(produtoRepository.listarTodos()).thenReturn(produtos);
    }

    @Test
    void listarProdutosTest() throws Exception {
        mockMvc.perform(get("/api/produtos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Geladeira"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nome").value("Fogão"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].nome").value("Máquina de Lavar"));
    }
}
