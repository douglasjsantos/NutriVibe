package br.com.fiap.nutrivibe.nutrivibe.repository;

import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Optional<Usuario> findByNome(String nome);

    public List<Usuario> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

}
