package com.example.mercado_facil.service;

import com.example.mercado_facil.model.Item;
import com.example.mercado_facil.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item criarItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item atualizarItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void apagarItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
