package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.dto.AgendamentoAtualizacaoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.AgendamentoCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.AgendamentoExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.model.Agendamento;
import br.com.fiap.nutrivibe.nutrivibe.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public AgendamentoExibitionDto gravar(@RequestBody @Valid AgendamentoCadastroDto agendamentoCadastroDto) {
        return service.gravar(agendamentoCadastroDto);
    }

    @GetMapping("/agendamentos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoExibitionDto buscarAgendamentoPeloId(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }

    @GetMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public Page<AgendamentoExibitionDto> listarTodosOsAgendamentos(Pageable pageable) {
        return service.listarTodosOsAgendamentos(pageable);
    }

    @PutMapping("/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public AgendamentoExibitionDto atualizar(@RequestBody @Valid AgendamentoAtualizacaoDto agendamentoAtualizacaoDto) {
        return service.Atualizar(agendamentoAtualizacaoDto);
    }

    @DeleteMapping("/agendamentos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

}
