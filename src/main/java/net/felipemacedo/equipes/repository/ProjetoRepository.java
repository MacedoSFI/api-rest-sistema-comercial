package net.felipemacedo.equipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.felipemacedo.equipes.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
