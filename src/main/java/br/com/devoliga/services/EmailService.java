package br.com.devoliga.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.devoliga.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
