package br.com.devoliga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devoliga.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
