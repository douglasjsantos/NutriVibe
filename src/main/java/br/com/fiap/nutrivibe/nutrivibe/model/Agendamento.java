package br.com.fiap.nutrivibe.nutrivibe.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Servico servico;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
