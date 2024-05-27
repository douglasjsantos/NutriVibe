package br.com.fiap.nutrivibe.nutrivibe.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProfissionalCadastroDto(

        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "A especialidade é obrigatório!")
        String especialidade,

        @NotBlank(message = "O preço anual é obrigatório!")
        BigDecimal precoPlanoAnual,

        @NotBlank(message = "O preço mensal é obrigatório!")
        BigDecimal precoPlanoMensal
) {
}
