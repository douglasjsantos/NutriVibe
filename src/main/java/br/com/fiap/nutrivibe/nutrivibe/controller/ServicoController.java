package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.model.Servico;
import br.com.fiap.nutrivibe.nutrivibe.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @PostMapping("/servicos")
    @ResponseStatus(HttpStatus.CREATED)
    public Servico gravar(@RequestBody Servico servico) {
        return service.gravar(servico);
    }

    @GetMapping("/servicos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Servico buscarServicoPeloId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/servicos")
    @ResponseStatus(HttpStatus.OK)
    public List<Servico> listarTodosOsServicos() {
        return service.listarTodosOsServicos();
    }

    @PutMapping("/servicos")
    @ResponseStatus(HttpStatus.OK)
    public Servico atualizar(@RequestBody Servico servico) {
        return service.Atualizar(servico);
    }

    @DeleteMapping("/servicos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


}
