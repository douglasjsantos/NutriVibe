package br.com.fiap.nutrivibe.nutrivibe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public record ServicoAtualizaçãoDto(
        @NotNull(message = "O ID é obrigatório!")
        Long id,
        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @NotBlank(message = "O preço é obrigatório!")
        BigDecimal preco,

        @NotBlank(message = "O Id do Profissional é obrigatório!")
        Long profissional_id
) {
}
