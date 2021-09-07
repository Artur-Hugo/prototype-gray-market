package br.com.devoliga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devoliga.domain.Cliente;
import br.com.devoliga.domain.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}
