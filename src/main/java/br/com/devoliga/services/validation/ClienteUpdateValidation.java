package br.com.devoliga.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.devoliga.domain.Cliente;
import br.com.devoliga.dto.ClienteDTO;
import br.com.devoliga.repositories.ClienteRepository;
import br.com.devoliga.resources.exception.FieldMessage;


//è o clienteDto, pq é especifico que a gente usa para atualizar!
public class ClienteUpdateValidation implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

	//Precisamos pegar a URL que tem o id '/id' como referencia 
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		// lista de erros percorridos implementados na classe
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}

		// inclua os testes aqui, inserindo erros na lista
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		//se a list percorrida não tiver erro então o metodo vai retornar verdadeiro
		return list.isEmpty();
	}
}
