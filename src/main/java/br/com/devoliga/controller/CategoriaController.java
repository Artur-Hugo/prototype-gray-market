package br.com.devoliga.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.devoliga.domain.Categoria;
import br.com.devoliga.repository.CategoriaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categorias")
@CrossOrigin(origins= "*", allowedHeaders="*")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable long id) throws ObjectNotFoundException{
		return categoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElseThrow(() -> new br.com.devoliga.service.exception.ObjectNotFoundException("Categoria não encontrada"));
	}
	
		
	
		
		
	

}
