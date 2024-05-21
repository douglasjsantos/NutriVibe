package br.com.fiap.nutrivibe.nutrivibe.service;

import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario gravar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPeloNome(String nome){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNome(nome);

        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario buscarPorId(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()){
            return usuarioOptional.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public List<Usuario> listarTodosOsUsuarios(){
        return usuarioRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
        } else{
            throw new RuntimeException("Usuário não localizado");
        }
    }


    public List<Usuario> mostrarAniversariantes(LocalDate dataInicial, LocalDate dataFinal){
        return usuarioRepository.findByDataNascimentoBetween(dataInicial,dataFinal);
    }
}
