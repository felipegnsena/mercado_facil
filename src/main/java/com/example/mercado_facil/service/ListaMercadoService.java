package com.example.mercado_facil.service;

import com.example.mercado_facil.model.ListaMercado;

import java.util.List;
import java.util.Optional;

public interface ListaMercadoService {

    ListaMercado criarListaMercado(ListaMercado listaMercado);

    ListaMercado atualizarListaMercado(ListaMercado listaMercado);

    Optional<ListaMercado> findById(Long id);

    void apagarListaMercado(Long idListaMercado);

    List<ListaMercado> findAll();
}
