package br.com.devoliga.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.devoliga.domain.Cliente;
import br.com.devoliga.domain.Pedido;

@Service
public class SmtpEmailService extends AbstractEmailService {
	
	//esse MailSender vai instanciar com todos o dados do email
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		mailSender.send(msg);
		LOG.info("Email enviado");
		
		
	}



	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		// TODO Auto-generated method stub
		LOG.info("Simulando envio de email...");
		javaMailSender.send(msg);
		LOG.info("Email enviado");
	}



	@Override
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		// TODO Auto-generated method stub
		LOG.info("Simulando envio de email...");
		LOG.info("Email enviado, cliente: " + cliente+ ", senha: " + newPass);
		LOG.info("Email enviado");
	}
	

}
