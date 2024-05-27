package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.Agendamento;
import br.com.fiap.nutrivibe.nutrivibe.model.Feedback;
import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;

public record FeedbackExibitionDto(
        Long id,
        String comentario,
        Agendamento agendamento
) {
    public FeedbackExibitionDto(Feedback feedback) {
        this(
                feedback.getId(),
                feedback.getComentario(),
                feedback.getAgendamento()
        );
    }
}
