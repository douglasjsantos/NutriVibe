package br.com.fiap.nutrivibe.nutrivibe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;


public record ServicoAtualizaçãoDto(
        @NotNull(message = "O ID é obrigatório!")
        Long id,
        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @NotNull(message = "O preço é obrigatório!")
        BigDecimal preco,

        @NotNull(message = "O Id do Profissional é obrigatório!")
        Long profissional_id
) {
}
