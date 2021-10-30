package br.com.devoliga.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.devoliga.security.UserSS;

public class UserService {
	
	//Esse pega o usuario que está logado no sistema
	public static UserSS authenticated() {
		try {
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
		}

}