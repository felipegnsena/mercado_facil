package com.example.mercado_facil.service;

import com.example.mercado_facil.model.ListaMercado;
import com.example.mercado_facil.repository.ListaMercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaMercadoServiceImpl implements ListaMercadoService {

    @Autowired
    private ListaMercadoRepository listaMercadoRepository;

    @Override
    public ListaMercado criarListaMercado(ListaMercado listaMercado) {
        return listaMercadoRepository.save(listaMercado);
    }

    @Override
    public List<ListaMercado> findAll() {
        return listaMercadoRepository.findAll();
    }
}
