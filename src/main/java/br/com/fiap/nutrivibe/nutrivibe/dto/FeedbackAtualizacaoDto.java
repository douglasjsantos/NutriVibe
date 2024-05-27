package br.com.fiap.nutrivibe.nutrivibe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FeedbackAtualizacaoDto(
        @NotNull(message = "O ID é obrigatório!")
        Long id,
        @NotBlank(message = "O comentário é obrigatório!")
        String comentario,
        @NotBlank(message = "O ID do agendamento é obrigatório!")
        Long agendamento_id

) {
}
