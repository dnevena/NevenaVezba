package com.example.nevena.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Labela {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String ime;
	
	@ManyToMany(mappedBy= "labelaList")
	private List<ToDo> todoList = new ArrayList<>();
	
	public Labela() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public List<ToDo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<ToDo> todoList) {
		this.todoList = todoList;
	}
	
	
	

	
	
	
}
