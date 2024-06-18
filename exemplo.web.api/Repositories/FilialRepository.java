package com.exemplo.webapi.repository;

import com.exemplo.webapi.model.Filial;
import java.util.ArrayList;
import java.util.List;

public class FilialRepository {
    private List<Filial> filiais = new ArrayList<>();

    public FilialRepository() {
        filiais.add(new Filial(1L, "Loja Central", "Av. Principal, 100"));
        filiais.add(new Filial(2L, "Filial Norte", "Rua Secundária, 200"));
    }

    public List<Filial> listarTodos() {
        return filiais;
    }
}
