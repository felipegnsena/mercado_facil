package com.example.mercado_facil.service;

import com.example.mercado_facil.model.ListaMercado;
import com.example.mercado_facil.repository.ItemRepository;
import com.example.mercado_facil.repository.ListaMercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaMercadoServiceImpl implements ListaMercadoService {

    @Autowired
    private ListaMercadoRepository listaMercadoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ListaMercado criarListaMercado(ListaMercado listaMercado) {
        var savedListaMercado = listaMercadoRepository.save(listaMercado);
        listaMercado.getItems().forEach(item -> {
            var itemOptional = itemRepository.findById(item.getId());
            if(itemOptional.isPresent()){
                var newItem = itemOptional.get();
                newItem.setListaMercado(savedListaMercado);
                itemRepository.save(newItem);
            }
        });
        return savedListaMercado;
    }

    @Override
    public ListaMercado atualizarListaMercado(ListaMercado listaMercado) {
        listaMercado.getItems().forEach(item -> {
            var itemOptional = itemRepository.findById(item.getId());
            if(itemOptional.isPresent()){
                var newItem = itemOptional.get();
                newItem.setListaMercado(listaMercado);
                itemRepository.save(newItem);
            }
        });
        return listaMercadoRepository.save(listaMercado);
    }

    @Override
    public Optional<ListaMercado> findById(Long id){
        return listaMercadoRepository.findById(id);
    }

    @Override
    public void apagarListaMercado(Long idListaMercado) {
        listaMercadoRepository.deleteById(idListaMercado);
    }

    @Override
    public List<ListaMercado> findAll() {
        return listaMercadoRepository.findAll();
    }
}
