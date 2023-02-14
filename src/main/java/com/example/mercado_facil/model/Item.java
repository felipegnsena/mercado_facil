package com.example.mercado_facil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nome")
    private String nome;

    @NotEmpty
    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "peso")
    private BigDecimal peso;

    @Column(name ="quantidade")
    private Long quantidade;

    @CreatedDate
    @Column(name = "dataCriacao")
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "dataAtualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "lista_mercado_id")
    private ListaMercado listaMercado;

}
