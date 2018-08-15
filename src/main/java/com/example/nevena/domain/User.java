package com.example.nevena.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	
	private String password;
	
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<ToDo> lista = new ArrayList<>();
	
	public User() {
		super();
	}

	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public List<ToDo> getLista() {
		return lista;
	}



	public void setLista(List<ToDo> lista) {
		this.lista = lista;
	}
	
	
	
	
}
