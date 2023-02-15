package com.example.mercado_facil.resource;

import com.example.mercado_facil.model.ListaMercado;
import com.example.mercado_facil.responses.Response;
import com.example.mercado_facil.service.ListaMercadoService;
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

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/lista_mercado")
public class ListaMercadoController {

    @Autowired
    private ListaMercadoService listaMercadoService;

    @PostMapping("/criar")
    public ResponseEntity<Response<ListaMercado>> criarListaMercado(@Valid @RequestBody ListaMercado listaMercado, BindingResult result) {
        var response = new Response<ListaMercado>();
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        var savedListaMercado = listaMercadoService.criarListaMercado(listaMercado);
        response.setData(savedListaMercado);
        return ok(response);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<Response<ListaMercado>> atualizarListaMercado(@Valid @RequestBody ListaMercado listaMercado, BindingResult result) {
        var response = new Response<ListaMercado>();
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        var oldListaMercado = listaMercadoService.findById(listaMercado.getId());
        if(oldListaMercado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var listaMercadoAtualizada = listaMercadoService.atualizarListaMercado(listaMercado);
        response.setData(listaMercadoAtualizada);
        return ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ListaMercado>> findAll() {
        var listaMercadoList = listaMercadoService.findAll();
        return ok(listaMercadoList);
    }

    @DeleteMapping("/apagar/{idListaMercado}")
    public ResponseEntity<Long> apagarListaMercado(@PathVariable Long idListaMercado){
        listaMercadoService.apagarListaMercado(idListaMercado);
        return ok(idListaMercado);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListaMercado> findById(@PathVariable long id){
        var listaMercadoOptional = listaMercadoService.findById(id);
        if(listaMercadoOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ok(listaMercadoOptional.get());
        }
    }

}
