package br.com.devoliga;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.devoliga.domain.Categoria;
import br.com.devoliga.domain.Cidade;
import br.com.devoliga.domain.Cliente;
import br.com.devoliga.domain.Endereco;
import br.com.devoliga.domain.Estado;
import br.com.devoliga.domain.Produto;
import br.com.devoliga.domain.enums.TipoCliente;
import br.com.devoliga.repository.CategoriaRepository;
import br.com.devoliga.repository.CidadeRepository;
import br.com.devoliga.repository.ClienteRepository;
import br.com.devoliga.repository.EnderecoRepository;
import br.com.devoliga.repository.EstadoRepository;
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
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
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
		
	     
		Estado est1 = new Estado( 1, "Minas Gerais");
		Estado est2 = new Estado( 2, "São Paulo");
		estadoRepository.save(est1);estadoRepository.save(est2);
		Cidade c1 = new Cidade(1, "Uberlândia",est1 );
		Cidade c2 = new Cidade( 2, "São Paulo",est2 );
		Cidade c3 = new Cidade( 3, "Campinas",est2 );
		cidadeRepository.save(c1);cidadeRepository.save(c2);cidadeRepository.save(c3);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		
		Cliente cli1 = new Cliente(3, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		clienteRepository.save(cli1);
		Endereco e1 = new Endereco(1, "Rua Flores", "300", "Apto 303", "Jardim", "38220834",cli1, c1);
		Endereco e2 = new Endereco(2, "Avenida Matos", "105", "Sala800", "Centro", "38777012", cli1, c2);
		
		 enderecoRepository.save(e1);enderecoRepository.save(e2);
		 cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		
		
		
	
		
	}

}
