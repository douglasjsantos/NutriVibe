package br.com.fiap.nutrivibe.nutrivibe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoAtualizacaoDto(
        @NotNull(message = "O ID é obrigatório!")
        Long id,
        @NotNull(message = "A dataHora é obrigatória!")
        LocalDateTime dataHora,
        @NotNull(message = "O ID do usuario é obrigatório!")
        Long usuario_id,
        @NotNull(message = "O ID do serviço é obrigatório!")
        Long servico_id
) {
}
