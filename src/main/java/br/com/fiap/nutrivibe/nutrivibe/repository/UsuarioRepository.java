package br.com.fiap.nutrivibe.nutrivibe.repository;

import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNome(String nome);
    UserDetails findByEmail(String email);

    Page<Usuario> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal, Pageable paginacao);

}
