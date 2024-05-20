package br.com.fiap.nutrivibe.nutrivibe.model;

import jakarta.persistence.*;

@Entity(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comentario;

    @ManyToOne
    private Usuario usuario;
}
