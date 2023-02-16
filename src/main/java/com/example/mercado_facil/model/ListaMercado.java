package com.example.mercado_facil.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@Table(name = "lista_mercado")
public class ListaMercado {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome da lista deverá ser informado")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "O valor da lista de items não pode ser nulo")
    @OneToMany(mappedBy = "listaMercado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;
}
