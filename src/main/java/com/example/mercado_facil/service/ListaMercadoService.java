package com.example.mercado_facil.service;

import com.example.mercado_facil.model.Item;
import com.example.mercado_facil.model.ListaMercado;

import java.util.List;

public interface ListaMercadoService {

    ListaMercado criarListaMercado(ListaMercado listaMercado);

    List<ListaMercado> findAll();
}
