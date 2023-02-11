package com.example.mercado_facil.service;

import com.example.mercado_facil.model.Item;

import java.util.List;

public interface ItemService {

    Item criarItem(Item item);

    List<Item> findAll();
}
