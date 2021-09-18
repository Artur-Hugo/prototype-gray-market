package br.com.devoliga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devoliga.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}