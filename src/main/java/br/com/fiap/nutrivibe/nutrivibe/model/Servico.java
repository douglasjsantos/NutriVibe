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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
}
