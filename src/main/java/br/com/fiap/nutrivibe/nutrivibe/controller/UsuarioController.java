package br.com.fiap.nutrivibe.nutrivibe.controller;


import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/security")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibitionDto gravar(@RequestBody UsuarioCadastroDto usuarioCadastroDto) {
        return service.gravar(usuarioCadastroDto);
    }

    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibitionDto buscarAgendamentoPeloId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping(value = "/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioExibitionDto> listarTodosOsContatos(Pageable paginacao) {
        return service.listarTodosOsUsuarios(paginacao);
    }

    @GetMapping(value = "/usuarios", params = "nome")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibitionDto buscarAgendamentoPeloNome(@RequestParam String nome) {
        return service.buscarPeloNome(nome);
    }

    @GetMapping("/usuarios/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioExibitionDto> mostrarAniversariantes(@PathVariable LocalDate dataInicial, @PathVariable LocalDate dataFinal, Pageable paginacao) {
        return service.mostrarAniversariantes(dataInicial, dataFinal, paginacao);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibitionDto atualizar(@RequestBody Usuario usuario) {
        return service.Atualizar(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }


}
