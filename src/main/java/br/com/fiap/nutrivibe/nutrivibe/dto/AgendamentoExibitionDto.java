package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.Agendamento;
import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.model.Servico;
import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;

import java.time.LocalDateTime;

public record AgendamentoExibitionDto(
        Long id,
        LocalDateTime dataHora,
        Usuario usuario,
        Servico servico

) {
    public AgendamentoExibitionDto(Agendamento agendamento) {
        this(
                agendamento.getId(),
                agendamento.getDataHora(),
                agendamento.getUsuario(),
                agendamento.getServico()
        );
    }
}
