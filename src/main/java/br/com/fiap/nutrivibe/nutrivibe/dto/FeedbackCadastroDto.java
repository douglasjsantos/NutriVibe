package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.Agendamento;
import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FeedbackCadastroDto(

        @NotBlank(message = "O comentário é obrigatório!")
        String comentario,

        @NotNull(message = "O ID do agendamento é obrigatório!")
        Long agendamento_id


){
}
