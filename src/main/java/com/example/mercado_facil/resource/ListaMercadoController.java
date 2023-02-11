package com.example.mercado_facil.resource;

import com.example.mercado_facil.model.ListaMercado;
import com.example.mercado_facil.service.ListaMercadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/lista_mercado")
public class ListaMercadoController {

    @Autowired
    private ListaMercadoService listaMercadoService;

    @PostMapping("/create")
    public ResponseEntity<ListaMercado> criarListaMercado(@Valid @RequestBody ListaMercado listaMercado) {
        var savedListaMercado = listaMercadoService.criarListaMercado(listaMercado);
        return ok(savedListaMercado);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ListaMercado>> findAll() {
        var listaMercadoList = listaMercadoService.findAll();
        return ok(listaMercadoList);
    }

}
