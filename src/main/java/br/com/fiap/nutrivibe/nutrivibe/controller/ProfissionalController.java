package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.dto.ProfissionalAtualizacaoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.ProfissionalCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.ProfissionalExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.service.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @PostMapping("/profissionais")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfissionalExibitionDto gravar(@RequestBody @Valid ProfissionalCadastroDto profissionalCadastroDto) {
        return service.gravar(profissionalCadastroDto);
    }

    @GetMapping("/profissionais/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProfissionalExibitionDto buscarProfissionalPeloId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/profissionais")
    @ResponseStatus(HttpStatus.OK)
    public Page<ProfissionalExibitionDto> listarTodosOsProfissionais(Pageable paginacao) {
        return service.listarTodosOsProfissionais(paginacao);
    }

    @PutMapping("/profissionais")
    @ResponseStatus(HttpStatus.OK)
    public ProfissionalExibitionDto atualizar(@RequestBody @Valid ProfissionalAtualizacaoDto profissionalAtualizacaoDto) {
        return service.Atualizar(profissionalAtualizacaoDto);
    }

    @DeleteMapping("/profissionais/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


}
