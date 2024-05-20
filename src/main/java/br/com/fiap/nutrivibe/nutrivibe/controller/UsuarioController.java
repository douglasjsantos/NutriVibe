package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/usuarios/{dataInicial}/{dataFinal}")
    public List<Usuario> mostrarAniversariantes(@PathVariable LocalDate dataInicial, @PathVariable LocalDate dataFinal){
        return service.mostrarAniversariantes(dataInicial,dataFinal);
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Usuario gravar(@RequestBody Usuario usuario){
        return service.gravar(usuario);
    }
}
