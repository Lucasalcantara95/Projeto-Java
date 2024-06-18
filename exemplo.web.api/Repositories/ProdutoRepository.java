package com.exemplo.webapi.repository;

import com.exemplo.webapi.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<>();

    public ProdutoRepository() {
        produtos.add(new Produto(1L, "Geladeira", "Eletrodoméstico", 2500.0));
        produtos.add(new Produto(2L, "Fogão", "Eletrodoméstico", 1200.0));
        produtos.add(new Produto(3L, "Máquina de Lavar", "Eletrodoméstico", 1800.0));
    }

    public List<Produto> listarTodos() {
        return produtos;
    }
}
