package br.com.devoliga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.devoliga.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	//readonly = true: Ela não necessita ser envolvida em transição com o banco de dados// ela faz ficar mais rápida no gerenciamento do banco de dados
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);


	
	
}
