package br.com.fiap.nutrivibe.nutrivibe.controller;

import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // criar um usuário
    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario gravar(@RequestBody Usuario usuario){
        return service.gravar(usuario);
    }

    // buscar usuário pelo nome
    @GetMapping("/usuarios/{nome}")
    public Usuario buscarUsuarioPeloNome(@PathVariable String nome){
        return service.buscarPeloNome(nome);
    }

    // listar todos os usuários
    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarTodosOsContatos(){
        return service.listarTodosOsUsuarios();
    }

    // excluir um usuário
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @GetMapping("/usuarios/{dataInicial}/{dataFinal}")
    public List<Usuario> mostrarAniversariantes(@PathVariable LocalDate dataInicial, @PathVariable LocalDate dataFinal){
        return service.mostrarAniversariantes(dataInicial,dataFinal);
    }


}
