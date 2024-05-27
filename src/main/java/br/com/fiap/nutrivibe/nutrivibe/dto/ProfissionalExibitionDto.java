package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;

import java.math.BigDecimal;

public record ProfissionalExibitionDto(
        Long id,
        String nome,
        String especialidade,
        BigDecimal precoPlanoAnual,
        BigDecimal precoPlanoMensal
) {
    public ProfissionalExibitionDto(Profissional profissional) {
        this(
                profissional.getId(),
                profissional.getNome(),
                profissional.getEspecialidade(),
                profissional.getPrecoPlanoAnual(),
                profissional.getPrecoPlanoMensal()
        );
    }
}
