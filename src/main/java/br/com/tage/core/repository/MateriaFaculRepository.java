package br.com.tage.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tage.core.model.MateriaFacul;

public interface MateriaFaculRepository extends JpaRepository<MateriaFacul, Integer> {
  List<MateriaFacul> findByNomeFaculContainsIgnoreCase(String nome);
}
