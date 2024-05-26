package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.Servico;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public record ServicoCadastroDto(
        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @NotBlank(message = "O preço é obrigatório!")
        BigDecimal preco,

        @NotBlank(message = "O Id do Profissional é obrigatório!")
        Long profissional_id
) {
}
