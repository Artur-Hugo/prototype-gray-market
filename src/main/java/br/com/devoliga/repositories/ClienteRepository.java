package br.com.devoliga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devoliga.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
