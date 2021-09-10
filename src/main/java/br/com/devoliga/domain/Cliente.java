package br.com.devoliga.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.devoliga.domain.enums.TipoCliente;
@Entity
public class Cliente implements Serializable{
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String nome;
private String email;
private String cpfOuCpnj;
private Integer tipo;


@OneToMany(mappedBy = "cliente")
@NotFound(action = NotFoundAction.IGNORE)
private List<Endereco> enderecos = new ArrayList<>();


@ElementCollection
@CollectionTable(name="TELEFONE")
private Set<String> telefones = new HashSet<>();

@JsonBackReference
@OneToMany(mappedBy="cliente")
private List<Pedido> pedidos = new ArrayList<>();

public Cliente() {}

public Cliente(long id, String nome, String email, String cpfOuCpnj, TipoCliente tipo) {
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.cpfOuCpnj = cpfOuCpnj;
	this.tipo = tipo.getCod();
}

public List<Endereco> getEnderecos() {
	return enderecos;
}

public void setEnderecos(List<Endereco> enderecos) {
	this.enderecos = enderecos;
}

public Set<String> getTelefones() {
	return telefones;
}

public void setTelefones(Set<String> telefones) {
	this.telefones = telefones;
}

public void setTipo(Integer tipo) {
	this.tipo = tipo;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCpfOuCpnj() {
	return cpfOuCpnj;
}

public void setCpfOuCpnj(String cpfOuCpnj) {
	this.cpfOuCpnj = cpfOuCpnj;
}

public TipoCliente getTipo() {
	return TipoCliente.toEnum(tipo);
}

public void setTipo(TipoCliente tipo) {
	this.tipo = tipo.getCod();
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	if (id != other.id)
		return false;
	return true;
}

public List<Pedido> getPedidos() {
	return pedidos;
}

public void setPedidos(List<Pedido> pedidos) {
	this.pedidos = pedidos;
}



}