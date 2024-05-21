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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
