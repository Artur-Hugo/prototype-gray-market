package br.com.devoliga.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.devoliga.enums.Perfil;

public class UserSS implements UserDetails{
<<<<<<< HEAD
	private static final long serialVersionUID = 1L;
	
	
=======

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
>>>>>>> arrumando
	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {}
	
<<<<<<< HEAD
=======
	
	
>>>>>>> arrumando
	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
<<<<<<< HEAD
	}

=======

	}



>>>>>>> arrumando
	public Integer getId() {
		return id;
	}
	
<<<<<<< HEAD
=======
	
>>>>>>> arrumando
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
<<<<<<< HEAD
=======
	

>>>>>>> arrumando

}
