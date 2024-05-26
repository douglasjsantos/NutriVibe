package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import br.com.fiap.nutrivibe.nutrivibe.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Profissional gravar(@RequestBody Profissional profissional) {
        return service.gravar(profissional);
    }

    @GetMapping("/profissionais/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Profissional buscarProfissionalPeloNome(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/profissionais")
    @ResponseStatus(HttpStatus.OK)
    public List<Profissional> listarTodosOsProfissionais() {
        return service.listarTodosOsProfissionais();
    }

    @PutMapping("/profissionais")
    @ResponseStatus(HttpStatus.OK)
    public Profissional atualizar(@RequestBody Profissional profissional) {
        return service.Atualizar(profissional);
    }

    @DeleteMapping("/profissionais/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


}
