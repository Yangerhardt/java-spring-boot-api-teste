package br.com.fcamara.equipes.repository;

import br.com.fcamara.equipes.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
