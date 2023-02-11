package com.example.mercado_facil.repository;

import com.example.mercado_facil.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
