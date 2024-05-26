package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.dto.ServicoAtualizaçãoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.ServicoCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.ServicoExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.model.Servico;
import br.com.fiap.nutrivibe.nutrivibe.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ServicoExibitionDto gravar(@RequestBody ServicoCadastroDto servicoCadastroDto) {
        return service.gravar(servicoCadastroDto);
    }

    @GetMapping("/servicos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServicoExibitionDto buscarServicoPeloId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/servicos")
    @ResponseStatus(HttpStatus.OK)
    public Page<ServicoExibitionDto> listarTodosOsServicos(Pageable paginacao) {
        return service.listarTodosOsServicos(paginacao);
    }

    @PutMapping("/servicos")
    @ResponseStatus(HttpStatus.OK)
    public ServicoExibitionDto atualizar(@RequestBody ServicoAtualizaçãoDto servicoAtualizaçãoDto) {
        return service.Atualizar(servicoAtualizaçãoDto);
    }

    @DeleteMapping("/servicos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


}
