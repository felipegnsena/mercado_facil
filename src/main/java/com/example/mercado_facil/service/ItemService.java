package com.example.mercado_facil.service;

import com.example.mercado_facil.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item criarItem(Item item);

    Item atualizarItem(Item item);

    void apagarItem(Long id);

    Optional<Item> findById(Long id);

    List<Item> findAll();
}
