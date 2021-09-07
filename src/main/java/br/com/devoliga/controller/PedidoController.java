package br.com.devoliga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devoliga.domain.Cliente;
import br.com.devoliga.domain.Pedido;
import br.com.devoliga.repository.PedidoRepository;

@RestController
@RequestMapping(value = "/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> getAll(){
		return ResponseEntity.ok(pedidoRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id){
		return pedidoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(null);
	}
}
