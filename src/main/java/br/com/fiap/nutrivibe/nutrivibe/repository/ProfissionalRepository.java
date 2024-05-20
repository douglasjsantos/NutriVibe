package br.com.fiap.nutrivibe.nutrivibe.repository;

import br.com.fiap.nutrivibe.nutrivibe.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
