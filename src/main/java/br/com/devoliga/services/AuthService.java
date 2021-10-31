package br.com.devoliga.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.devoliga.domain.Cliente;
import br.com.devoliga.repositories.ClienteRepository;
import br.com.devoliga.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService emailService;

	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		// TODO Auto-generated method stub
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		// TODO Auto-generated method stub
		int opt = rand.nextInt(3);
		if (opt == 0) { //gera um digito
			return (char) (rand.nextInt(10) + 48);
		} else if (opt == 1) { //gera letra maiscula
			return (char) (rand.nextInt(26) + 65);
		}
		else {// gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
		
		
	}
}
