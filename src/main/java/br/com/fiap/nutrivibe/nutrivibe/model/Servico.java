package br.com.fiap.nutrivibe.nutrivibe.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private BigDecimal preco;

    @ManyToOne
    private Profissional profissional;
}
