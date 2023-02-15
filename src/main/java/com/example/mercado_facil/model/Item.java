package com.example.mercado_facil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.hibernate.validator.constraints.Length;
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

    @NotEmpty(message = "O nome do item deverá ser informado!")
    @Length(min=5, max=200, message="O nome do item deverá ter de 5 a 200 caracteres")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "O preço do item deverá ser informado!")
    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "peso")
    private BigDecimal peso;

    @NotNull(message = "A quantidade de itens deverá ser informada!")
    @Column(name ="quantidade")
    private Long quantidade;

    @CreatedDate
    @Column(name = "dataCriacao")
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "dataAtualizacao")
    private LocalDateTime dataAtualizacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lista_mercado_id")
    private ListaMercado listaMercado;

}
