package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.model.Servico;

import java.math.BigDecimal;

public record ServicoExibitionDto(
        Long id,
        String descricao,
        BigDecimal preco,
        Profissional profissional

) {
    public ServicoExibitionDto(Servico servico) {
        this(
                servico.getId(),
                servico.getDescricao(),
                servico.getPreco(),
                servico.getProfissional()
        );
    }
}
