package br.com.devoliga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devoliga.domain.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	//public List<Categoria> findByIdContainingIgnoreCase(Long id);
}
