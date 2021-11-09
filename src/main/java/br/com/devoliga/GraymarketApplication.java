package br.com.devoliga;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
import br.com.devoliga.enums.Perfil;
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
import br.com.devoliga.services.S3Service;

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
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Override
	public void run(String... args) throws Exception {
	
		// TODO Auto-generated method stub
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
		produtoRepository.save(p5);produtoRepository.save(p6);produtoRepository.save(p7);
		produtoRepository.save(p8);produtoRepository.save(p9);produtoRepository.save(p10);produtoRepository.save(p11);
		
		
		Produto p12 = new Produto(12, "Produto 12", 10.00);
		Produto p13 = new Produto(13, "Produto 13", 10.00);
		Produto p14 = new Produto(14, "Produto 14", 10.00);
		Produto p15 = new Produto(15, "Produto 15", 10.00);
		Produto p16 = new Produto(16, "Produto 16", 10.00);
		Produto p17 = new Produto(17, "Produto 17", 10.00);
		Produto p18 = new Produto(18, "Produto 18", 10.00);
		Produto p19 = new Produto(19, "Produto 19", 10.00);
		Produto p20 = new Produto(20, "Produto 20", 10.00);
		Produto p21 = new Produto(21, "Produto 21", 10.00);
		Produto p22 = new Produto(22, "Produto 22", 10.00);
		Produto p23 = new Produto(23, "Produto 23", 10.00);
		Produto p24 = new Produto(24, "Produto 24", 10.00);
		Produto p25 = new Produto(25, "Produto 25", 10.00);
		Produto p26 = new Produto(26, "Produto 26", 10.00);
		Produto p27 = new Produto(27, "Produto 27", 10.00);
		Produto p28 = new Produto(28, "Produto 28", 10.00);
		Produto p29 = new Produto(29, "Produto 29", 10.00);
		Produto p30 = new Produto(30, "Produto 30", 10.00);
		Produto p31 = new Produto(31, "Produto 31", 10.00);
		Produto p32 = new Produto(32, "Produto 32", 10.00);
		Produto p33 = new Produto(33, "Produto 33", 10.00);
		Produto p34 = new Produto(34, "Produto 34", 10.00);
		Produto p35 = new Produto(35, "Produto 35", 10.00);
		Produto p36 = new Produto(36, "Produto 36", 10.00);
		Produto p37 = new Produto(37, "Produto 37", 10.00);
		Produto p38 = new Produto(38, "Produto 38", 10.00);
		Produto p39 = new Produto(39, "Produto 39", 10.00);
		Produto p40 = new Produto(40, "Produto 40", 10.00);
		Produto p41 = new Produto(41, "Produto 41", 10.00);
		Produto p42 = new Produto(42, "Produto 42", 10.00);
		Produto p43 = new Produto(43, "Produto 43", 10.00);
		Produto p44 = new Produto(44, "Produto 44", 10.00);
		Produto p45 = new Produto(45, "Produto 45", 10.00);
		Produto p46 = new Produto(46, "Produto 46", 10.00);
		Produto p47 = new Produto(47, "Produto 47", 10.00);
		Produto p48 = new Produto(48, "Produto 48", 10.00);
		Produto p49 = new Produto(49, "Produto 49", 10.00);
		Produto p50 = new Produto(50, "Produto 50", 10.00);
		

		
		
	
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
		
		p12.getCategorias().add(cat1);
		p13.getCategorias().add(cat1);
		p14.getCategorias().add(cat1);
		p15.getCategorias().add(cat1);
		p16.getCategorias().add(cat1);
		p17.getCategorias().add(cat1);
		p18.getCategorias().add(cat1);
		p19.getCategorias().add(cat1);
		p20.getCategorias().add(cat1);
		p21.getCategorias().add(cat1);
		p22.getCategorias().add(cat1);
		p23.getCategorias().add(cat1);
		p24.getCategorias().add(cat1);
		p25.getCategorias().add(cat1);
		p26.getCategorias().add(cat1);
		p27.getCategorias().add(cat1);
		p28.getCategorias().add(cat1);
		p29.getCategorias().add(cat1);
		p30.getCategorias().add(cat1);
		p31.getCategorias().add(cat1);
		p32.getCategorias().add(cat1);
		p33.getCategorias().add(cat1);
		p34.getCategorias().add(cat1);
		p35.getCategorias().add(cat1);
		p36.getCategorias().add(cat1);
		p37.getCategorias().add(cat1);
		p38.getCategorias().add(cat1);
		p39.getCategorias().add(cat1);
		p40.getCategorias().add(cat1);
		p41.getCategorias().add(cat1);
		p42.getCategorias().add(cat1);
		p43.getCategorias().add(cat1);
		p44.getCategorias().add(cat1);
		p45.getCategorias().add(cat1);
		p46.getCategorias().add(cat1);
		p47.getCategorias().add(cat1);
		p48.getCategorias().add(cat1);
		p49.getCategorias().add(cat1);
		p50.getCategorias().add(cat1);
		
		produtoRepository.save(p12);produtoRepository.save(p13);produtoRepository.save(p14);produtoRepository.save(p15);
		produtoRepository.save(p16);produtoRepository.save(p17);produtoRepository.save(p18);produtoRepository.save(p19);
		produtoRepository.save(p20);produtoRepository.save(p21);produtoRepository.save(p22);produtoRepository.save(p23);
		produtoRepository.save(p24);produtoRepository.save(p25);produtoRepository.save(p26);produtoRepository.save(p27);
		produtoRepository.save(p28);produtoRepository.save(p29);produtoRepository.save(p30);produtoRepository.save(p31);
		produtoRepository.save(p32);produtoRepository.save(p33);produtoRepository.save(p34);produtoRepository.save(p35);
		produtoRepository.save(p36);produtoRepository.save(p37);produtoRepository.save(p38);produtoRepository.save(p39);
		produtoRepository.save(p40);produtoRepository.save(p41);produtoRepository.save(p42);produtoRepository.save(p43);
		produtoRepository.save(p44);produtoRepository.save(p45);produtoRepository.save(p46);produtoRepository.save(p47);
		produtoRepository.save(p48);produtoRepository.save(p49);produtoRepository.save(p50);
		
		
		Estado est1 = new Estado(  1, "Minas Gerais");
		Estado est2 = new Estado( 2, "São Paulo");
		estadoRepository.save(est1);estadoRepository.save(est2);
		Cidade c1 = new Cidade(1, "Uberlândia",est1 );
		Cidade c2 = new Cidade( 2, "São Paulo",est2 );
		Cidade c3 = new Cidade( 3, "Campinas",est2 );
		cidadeRepository.save(c1);cidadeRepository.save(c2);cidadeRepository.save(c3);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		Cliente cli1 = new Cliente(1, "Maria Silva", "pokerxadrez4@gmail.com", "36378912377", TipoCliente.PESSOAFISICA, pe.encode("bf1234"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		cli1.addPerfil(Perfil.CLIENTE);
		clienteRepository.save(cli1);
		
		Cliente cli2 = new Cliente(2, "Ana Costa", "pokerxadrez44@gmail.com", "53104861005", TipoCliente.PESSOAFISICA, pe.encode("bf1234"));
		cli2.addPerfil(Perfil.CLIENTE);
		cli2.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("87333323", "81238393"));
		clienteRepository.save(cli2);
		
		Endereco e1 = new Endereco( 1, "Rua Flores", "300", "Apto 303", "Jardim", "38220834",cli1, c1);
		Endereco e2 = new Endereco( 2, "Avenida Matos", "105", "Sala800", "Centro", "38777012", cli1, c2);
		Endereco e3 = new Endereco(3, "Avenida Floriano", "2106", null, "Centro", "2817777012", cli2, c2);
		
		 enderecoRepository.save(e1);enderecoRepository.save(e2);enderecoRepository.save(e3);
		 cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
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
