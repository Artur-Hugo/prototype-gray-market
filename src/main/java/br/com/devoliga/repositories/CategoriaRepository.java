package br.com.devoliga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devoliga.domain.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
