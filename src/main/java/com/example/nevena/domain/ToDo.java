package com.example.nevena.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "zadaci")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "naziv", unique = true)
	private String title;
	
	@Column(name = "opis")
	private String description;
	
	@OneToOne
	private Priority priority;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	@ManyToMany
	@JoinTable(joinColumns={@JoinColumn(name="todo_id")},inverseJoinColumns={@JoinColumn(name="labela_id")})
	private List<Labela> labelaList = new ArrayList<>();
	
	public ToDo() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Labela> getLabelaList() {
		return labelaList;
	}
	public void setLabelaList(List<Labela> labelaList) {
		this.labelaList = labelaList;
	}
	
	

}
