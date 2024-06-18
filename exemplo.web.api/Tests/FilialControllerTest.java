package com.exemplo.webapi.controller;

import com.exemplo.webapi.model.Filial;
import com.exemplo.webapi.repository.FilialRepository;
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

@WebMvcTest(FilialController.class)
public class FilialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilialRepository filialRepository;

    private List<Filial> filiais;

    @BeforeEach
    void setUp() {
        filiais = Arrays.asList(
                new Filial(1L, "Loja Central", "Av. Principal, 100"),
                new Filial(2L, "Filial Norte", "Rua Secundária, 200")
        );

        when(filialRepository.listarTodos()).thenReturn(filiais);
    }

    @Test
    void listarFiliaisTest() throws Exception {
        mockMvc.perform(get("/api/filiais"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Loja Central"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nome").value("Filial Norte"));
    }
}
