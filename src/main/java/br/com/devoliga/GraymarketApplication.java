package br.com.devoliga;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.devoliga.domain.Categoria;
import br.com.devoliga.domain.Produto;
import br.com.devoliga.repository.CategoriaRepository;
import br.com.devoliga.repository.ProdutoRepository;

@SpringBootApplication
public class GraymarketApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GraymarketApplication.class, args);
	}
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritório");
	
		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);
	
		Produto p1 = new Produto(1, "Computador", 2000.00);
		Produto p2 = new Produto(2, "Impressora", 800.00);
		Produto p3 = new Produto(3, "Mouse", 80.00);
	
		produtoRepository.save(p1);produtoRepository.save(p2);
		produtoRepository.save(p3);
	
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
	
		 categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	     produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	
	}

}
