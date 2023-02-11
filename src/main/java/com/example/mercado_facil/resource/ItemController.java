package com.example.mercado_facil.resource;

import com.example.mercado_facil.model.Item;
import com.example.mercado_facil.service.ItemService;
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
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<Item> criarItem(@Valid @RequestBody Item item) {
        var savedItem = itemService.criarItem(item);
        return ok(savedItem);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> findAll() {
        var itemsList = itemService.findAll();
        return ok(itemsList);
    }
}
