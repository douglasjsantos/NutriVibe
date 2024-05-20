package br.com.fiap.nutrivibe.nutrivibe.service;

import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario gravar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> mostrarAniversariantes(LocalDate dataInicial, LocalDate dataFinal){
        return usuarioRepository.findByDataNascimentoBetween(dataInicial,dataFinal);
    }
}
