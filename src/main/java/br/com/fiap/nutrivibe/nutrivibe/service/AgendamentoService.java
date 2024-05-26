package br.com.fiap.nutrivibe.nutrivibe.service;


import br.com.fiap.nutrivibe.nutrivibe.model.Agendamento;
import br.com.fiap.nutrivibe.nutrivibe.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento gravar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento buscarPeloId(Long id) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);

        if (agendamentoOptional.isPresent()) {
            return agendamentoOptional.get();
        } else {
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public List<Agendamento> listarTodosOsAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento Atualizar(Agendamento agendamento) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamento.getId());

        if (agendamentoOptional.isPresent()) {
            return agendamentoRepository.save(agendamentoOptional.get());
        } else {
            throw new RuntimeException("Agendamento não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);

        if (agendamentoOptional.isPresent()) {
            agendamentoRepository.delete(agendamentoOptional.get());
        } else {
            throw new RuntimeException("Agendamento não localizado");
        }
    }

}
