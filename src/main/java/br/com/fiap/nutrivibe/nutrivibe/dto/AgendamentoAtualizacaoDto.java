package br.com.fiap.nutrivibe.nutrivibe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoAtualizacaoDto(
        @NotNull(message = "O ID é obrigatório!")
        Long id,
        @NotBlank(message = "A dataHora é obrigatória!")
        LocalDateTime dataHora,
        @NotBlank(message = "O ID do usuario é obrigatório!")
        Long usuario_id,
        @NotBlank(message = "O ID do serviço é obrigatório!")
        Long servico_id
) {
}
