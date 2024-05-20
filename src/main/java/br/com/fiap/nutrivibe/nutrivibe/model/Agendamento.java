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

}
