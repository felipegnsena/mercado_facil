package com.example.mercado_facil.resource;

import com.example.mercado_facil.model.Item;
import com.example.mercado_facil.model.ListaMercado;
import com.example.mercado_facil.responses.Response;
import com.example.mercado_facil.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/criar")
    public ResponseEntity<Response<Item>> criarItem(@Valid @RequestBody Item item, BindingResult result) {
        var response = new Response<Item>();
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        var savedItem = itemService.criarItem(item);
        response.setData(savedItem);
        return ok(response);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<Response<Item>> atualizarItem(@Valid @RequestBody Item item, BindingResult result) {
        var response = new Response<Item>();
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        var oldItem = itemService.findById(item.getId());
        if(oldItem.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var savedItem = itemService.atualizarItem(item);
        response.setData(savedItem);
        return ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> findAll() {
        var itemsList = itemService.findAll();
        return ok(itemsList);
    }

    @DeleteMapping("/apagar/{idItem}")
    public ResponseEntity<Long> apagarItem(@PathVariable("idItem") Long idItem){
        itemService.apagarItem(idItem);
        return ok(idItem);
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> findById(@PathVariable("id") long id){
        var itemOptional = itemService.findById(id);
        if(itemOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ok(itemOptional.get());
        }
    }
}
