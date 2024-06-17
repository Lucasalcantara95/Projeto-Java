package com.exemplo.controller;

import com.exemplo.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    // Simula dados de produtos
    public ProdutoController() {
        produtos.add(new Produto(1L, "Geladeira", "Eletrodoméstico", 2500.0));
        produtos.add(new Produto(2L, "Fogão", "Eletrodoméstico", 1200.0));
        produtos.add(new Produto(3L, "Máquina de Lavar", "Eletrodoméstico", 1800.0));
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtos;
    }
}
