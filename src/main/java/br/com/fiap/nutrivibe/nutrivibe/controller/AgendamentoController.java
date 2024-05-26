package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.model.Agendamento;
import br.com.fiap.nutrivibe.nutrivibe.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping("/agendamentos")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento gravar(@RequestBody Agendamento agendamento) {
        return service.gravar(agendamento);
    }

    @GetMapping("/agendamentos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agendamento buscarAgendamentoPeloId(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }

    @GetMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public List<Agendamento> listarTodosOsAgendamentos() {
        return service.listarTodosOsAgendamentos();
    }

    @PutMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public Agendamento atualizar(@RequestBody Agendamento agendamento) {
        return service.Atualizar(agendamento);
    }

    @DeleteMapping("/agendamentos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
