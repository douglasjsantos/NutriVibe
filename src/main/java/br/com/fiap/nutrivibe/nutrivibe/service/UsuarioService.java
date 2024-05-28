package br.com.fiap.nutrivibe.nutrivibe.service;


import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioAtualizacaoDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioCadastroDto;
import br.com.fiap.nutrivibe.nutrivibe.dto.UsuarioExibitionDto;
import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import br.com.fiap.nutrivibe.nutrivibe.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibitionDto gravar(UsuarioCadastroDto usuarioCadastroDto) {
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);
        usuario.setSenha(senhaCriptografada);
        return new UsuarioExibitionDto(usuarioRepository.save(usuario));
    }

    public UsuarioExibitionDto buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            return new UsuarioExibitionDto(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Page<UsuarioExibitionDto> listarTodosOsUsuarios(Pageable paginacao) {
        Page<UsuarioExibitionDto> usuarios = usuarioRepository
                .findAll(paginacao)
                .map(UsuarioExibitionDto::new);
        return usuarios;
    }

    public UsuarioExibitionDto buscarPeloNome(String nome) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByNome(nome);

        if (usuarioOptional.isPresent()) {
            return new UsuarioExibitionDto(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }


    public Page<UsuarioExibitionDto> mostrarAniversariantes(LocalDate dataInicial, LocalDate dataFinal,Pageable paginacao) {
        Page<UsuarioExibitionDto> usuarios = usuarioRepository
                .findByDataNascimentoBetween(dataInicial, dataFinal,paginacao)
                .map(UsuarioExibitionDto::new);
        return usuarios;
    }

    public UsuarioExibitionDto Atualizar(UsuarioAtualizacaoDto usuarioAtualizacaoDto) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioAtualizacaoDto.id());

        if (usuarioOptional.isPresent()) {
            String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioAtualizacaoDto.senha());

            Usuario usuario = usuarioOptional.get();

            usuario.setSenha(senhaCriptografada);

            return new UsuarioExibitionDto(usuarioRepository.save(usuario));
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    public void excluir(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não localizado");
        }
    }


}
