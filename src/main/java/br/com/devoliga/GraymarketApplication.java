package br.com.devoliga;


import java.text.SimpleDateFormat;
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
import br.com.devoliga.domain.ItemPedido;
import br.com.devoliga.domain.Pagamento;
import br.com.devoliga.domain.PagamentoComBoleto;
import br.com.devoliga.domain.PagamentoComCartao;
import br.com.devoliga.domain.Pedido;
import br.com.devoliga.domain.Produto;
import br.com.devoliga.domain.enums.EstadoPagamento;
import br.com.devoliga.domain.enums.TipoCliente;
import br.com.devoliga.repository.CategoriaRepository;
import br.com.devoliga.repository.CidadeRepository;
import br.com.devoliga.repository.ClienteRepository;
import br.com.devoliga.repository.EnderecoRepository;
import br.com.devoliga.repository.EstadoRepository;
import br.com.devoliga.repository.ItemPedidoRepository;
import br.com.devoliga.repository.PagamentoRepository;
import br.com.devoliga.repository.PedidoRepository;
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
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(1, sdf.parse("30/09/2017 10:32"),  cli1, e1);
		Pedido ped2 = new Pedido(2, sdf.parse("10/10/2017 19:32"),  cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(1, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(2, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),null );
		ped2.setPagamento(pagto2);
	
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.save(ped1);pedidoRepository.save(ped2);
		pagamentoRepository.save(pagto1);pagamentoRepository.save(pagto2);
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
	
		itemPedidoRepository.save(ip1);itemPedidoRepository.save(ip2);itemPedidoRepository.save(ip3);
	}

}
