package br.com.devoliga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devoliga.domain.Pagamento;
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
