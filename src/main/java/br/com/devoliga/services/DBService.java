package br.com.devoliga.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;

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
import br.com.devoliga.enums.EstadoPagamento;
import br.com.devoliga.enums.TipoCliente;
import br.com.devoliga.repositories.CategoriaRepository;
import br.com.devoliga.repositories.CidadeRepository;
import br.com.devoliga.repositories.ClienteRepository;
import br.com.devoliga.repositories.EnderecoRepository;
import br.com.devoliga.repositories.EstadoRepository;
import br.com.devoliga.repositories.ItemPedidoRepository;
import br.com.devoliga.repositories.PagamentoRepository;
import br.com.devoliga.repositories.PedidoRepository;
import br.com.devoliga.repositories.ProdutoRepository;

@Service
public class DBService {
	
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
	
	public void instantiateTestDatabase() throws ParseException{
		
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritório");
		Categoria cat3 = new Categoria(3, "Cama mesa e banho");
		Categoria cat4 = new Categoria(4, "Eletrônico");
		Categoria cat5 = new Categoria(5, "Jardinagem");
		Categoria cat6 = new Categoria(6, "Decoração");
		Categoria cat7 = new Categoria(7, "Perfumaria");
	
		categoriaRepository.save(cat1);categoriaRepository.save(cat2);categoriaRepository.save(cat3);
		categoriaRepository.save(cat4);categoriaRepository.save(cat5);categoriaRepository.save(cat6);categoriaRepository.save(cat7);
		
		
		Produto p1 = new Produto(1, "Computador", 2000.00);
		Produto p2 = new Produto(2, "Impressora", 800.00);
		Produto p3 = new Produto(3, "Mouse", 80.00);
		Produto p4 = new Produto(4, "Mesa de escritorio", 300.00);
		Produto p5 = new Produto(5, "Toalha", 50.00);
		Produto p6 = new Produto(6, "Colcha", 200.00);
		Produto p7 = new Produto(7, "Tv true color", 1200.00);
		Produto p8 = new Produto(8, "Roçadeira", 800.00);
		Produto p9 = new Produto(9, "Abajour", 100.00);
		Produto p10 = new Produto(10, "Pendente", 180.00);
		Produto p11 = new Produto(11, "Shampoo", 90.00);
		
		produtoRepository.save(p1);produtoRepository.save(p2);produtoRepository.save(p3);produtoRepository.save(p4);
		produtoRepository.save(p8);produtoRepository.save(p9);produtoRepository.save(p10);produtoRepository.save(p11);
		
		
		
	
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
	
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
	     
		Estado est1 = new Estado(  1, "Minas Gerais");
		Estado est2 = new Estado( 2, "São Paulo");
		estadoRepository.save(est1);estadoRepository.save(est2);
		Cidade c1 = new Cidade(1, "Uberlândia",est1 );
		Cidade c2 = new Cidade( 2, "São Paulo",est2 );
		Cidade c3 = new Cidade( 3, "Campinas",est2 );
		cidadeRepository.save(c1);cidadeRepository.save(c2);cidadeRepository.save(c3);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		
		Cliente cli1 = new Cliente(1, "Maria Silva", "pokerxadrez4@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		clienteRepository.save(cli1);
		Endereco e1 = new Endereco( 1, "Rua Flores", "300", "Apto 303", "Jardim", "38220834",cli1, c1);
		Endereco e2 = new Endereco( 2, "Avenida Matos", "105", "Sala800", "Centro", "38777012", cli1, c2);
		
		 enderecoRepository.save(e1);enderecoRepository.save(e2);
		 cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido( 1, sdf.parse("30/09/2017 10:32"),  cli1, e1);
		Pedido ped2 = new Pedido( 2, sdf.parse("10/10/2017 19:32"),  cli1, e2);
		
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
