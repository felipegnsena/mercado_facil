package com.example.mercado_facil.service;

import com.example.mercado_facil.model.ListaMercado;

import java.util.List;

public interface ListaMercadoService {

    ListaMercado criarListaMercado(ListaMercado listaMercado);

    ListaMercado atualizarListaMercado(ListaMercado listaMercado);

    void apagarListaMercado(Long idListaMercado);

    List<ListaMercado> findAll();
}
