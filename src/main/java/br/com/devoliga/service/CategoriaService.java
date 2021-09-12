package br.com.devoliga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.MethodArgumentNotValidException;

import br.com.devoliga.domain.Categoria;
import br.com.devoliga.dto.CategoriaDTO;
import br.com.devoliga.repository.CategoriaRepository;
import br.com.devoliga.service.exception.ObjectNotFoundException;

public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(),objDto.getNome());}
	
	public Page<Categoria> findPageFuncion(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
	
	
	public Categoria insert(Categoria obj) {
		obj.setId((Long) null);
		return categoriaRepository.save(obj);
		
	}
}
