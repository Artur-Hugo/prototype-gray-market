package br.com.devoliga.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.devoliga.domain.Cliente;
import br.com.devoliga.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	private SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		//Destinatário do email
		sm.setTo(obj.getCliente().getEmail());
		//Rementente do email
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		
		return sm;
	}
   
	@Override   
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
		sendEmail(sm);
	}
	
	
	protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
		// TODO Auto-generated method stub
		SimpleMailMessage sm = new SimpleMailMessage();
		//Destinatário do email
		sm.setTo(cliente.getEmail());
		//Rementente do email
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		
		return sm;
	}

	//Método para jogar o valor no html com thimeleaf
	protected String htmlFromTemplatePedido(Pedido obj) {
	Context context = new Context();
	context.setVariable("pedido", obj);
	return templateEngine.process("email/confirmacaoPedido", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		//gerar mensagem do pedido
		try {
		MimeMessage sm = prepareMimeMessageFromPedido(obj);
		sendHtmlEmail(sm);
		}catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}

	protected MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getCliente().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Pedido confirmado! Código: " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj), true);
		
		return mimeMessage;
		
		
	}
	
	
}
