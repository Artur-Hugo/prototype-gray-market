package br.com.devoliga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devoliga.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
