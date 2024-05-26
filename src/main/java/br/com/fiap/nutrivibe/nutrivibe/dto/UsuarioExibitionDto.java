package br.com.fiap.nutrivibe.nutrivibe.dto;

import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;

import java.time.LocalDate;

public record UsuarioExibitionDto(
        Long id,
        String nome,
        String email,
        String cpf,
        LocalDate dataNascimento

) {
    public UsuarioExibitionDto(Usuario usuario){
        this(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getCpf(),
            usuario.getDataNascimento()
        );
    }
}
