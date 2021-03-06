package br.com.devoliga.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.devoliga.domain.Categoria;
import br.com.devoliga.domain.Cliente;
import br.com.devoliga.dto.ClienteNewDTO;
import br.com.devoliga.enums.TipoCliente;
import br.com.devoliga.repositories.ClienteRepository;
import br.com.devoliga.resources.exception.FieldMessage;
import br.com.devoliga.services.validation.utils.BR;

public class ClienteInsertValidation implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	//Programa de inicialização
	@Override
	 public void initialize(ClienteInsert ann) {
	 }
	 
	 //O isValid faz com que o @valid dependa do que está no método isValid
	 @Override
	 public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
	
		 //lista de erros percorridos implementados na classe
		 List<FieldMessage> list = new ArrayList<>();
		 
		 if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			 list.add(new FieldMessage("cpfOuCnpj","CPF inválido"));
		 }

		 if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			 list.add(new FieldMessage("cpfOuCnpj","CNPJ inválido"));
		 }
		 
		 Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
		 if(aux != null) {
			 list.add(new FieldMessage("email", "Email já existente"));
		 }
		 
		 
		 
	 // inclua os testes aqui, inserindo erros na lista
	 for (FieldMessage e : list) {
	 context.disableDefaultConstraintViolation();
	 context.buildConstraintViolationWithTemplate(e.getMessage())
	 .addPropertyNode(e.getFieldName()).addConstraintViolation();
	 }
	 
	 //se a list percorrida não tiver erro então o metodo vai retornar verdadeiro
	 return list.isEmpty();
	 }
	}
