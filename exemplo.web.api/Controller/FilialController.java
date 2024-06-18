package com.exemplo.webapi.controller;

import com.exemplo.webapi.model.Filial;
import com.exemplo.webapi.repository.FilialRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filiais")
public class FilialController {
    private FilialRepository filialRepository = new FilialRepository();

    @GetMapping
    public List<Filial> listarFiliais() {
        return filialRepository.listarTodos();
    }
}
