package br.com.fiap.nutrivibe.nutrivibe.repository;

import br.com.fiap.nutrivibe.nutrivibe.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Usuario, Long> {
}
