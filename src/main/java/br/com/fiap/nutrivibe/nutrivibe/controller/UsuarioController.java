package br.com.fiap.nutrivibe.nutrivibe.controller;


import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/security")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario gravar(@RequestBody Usuario usuario) {
        return service.gravar(usuario);
    }

    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarAgendamentoPeloId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping(value = "/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarTodosOsContatos() {
        return service.listarTodosOsUsuarios();
    }

    @GetMapping(value = "/usuarios", params = "nome")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarAgendamentoPeloNome(@RequestParam String nome) {
        return service.buscarPeloNome(nome);
    }

    @GetMapping("/usuarios/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> mostrarAniversariantes(@PathVariable LocalDate dataInicial, @PathVariable LocalDate dataFinal) {
        return service.mostrarAniversariantes(dataInicial, dataFinal);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario) {
        return service.Atualizar(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


}
