package br.com.fiap.nutrivibe.nutrivibe.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String especialidade;

    @Column(name = "preco_plano_anual")
    private BigDecimal precoPlanoAnual;

    @Column(name = "preco_plano_mensal")
    private BigDecimal precoPlanoMensal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public BigDecimal getPrecoPlanoAnual() {
        return precoPlanoAnual;
    }

    public void setPrecoPlanoAnual(BigDecimal precoPlanoAnual) {
        this.precoPlanoAnual = precoPlanoAnual;
    }

    public BigDecimal getPrecoPlanoMensal() {
        return precoPlanoMensal;
    }

    public void setPrecoPlanoMensal(BigDecimal precoPlanoMensal) {
        this.precoPlanoMensal = precoPlanoMensal;
    }
}
