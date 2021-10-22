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

@SpringBootApplication
public class GraymarketApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GraymarketApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
