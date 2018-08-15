package com.example.nevena.controller.dto;

import java.util.List;

public class ToDoDTO {
	
	private String title;
	private String description;
	private Long priorityId;
	private Long userId;
	private List<Long> labelaId;
	
	
	public ToDoDTO() {
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
	public Long getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Long> getLabelaId() {
		return labelaId;
	}
	public void setLabelaId(List<Long> labelaId) {
		this.labelaId = labelaId;
	}
	
	

}
