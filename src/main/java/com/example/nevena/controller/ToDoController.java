package com.example.nevena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.nevena.controller.dto.ToDoDTO;
import com.example.nevena.domain.ToDo;
import com.example.nevena.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;
	
	
	@PostMapping("")
	public ToDo createTodo(@RequestBody ToDoDTO toDoDto) {
		return toDoService.createToDo(toDoDto.getTitle(), toDoDto.getDescription(), toDoDto.getPriorityId(), toDoDto.getUserId(), toDoDto.getLabelaId());
		
	}
	

	@DeleteMapping("/{id}")
	public void  delete(@PathVariable("id") Long id) {
		toDoService.delete(id);
		
	}
	
	@GetMapping("")
	public List<ToDo> getAll () {
		return toDoService.findAll();
		
	}

	@GetMapping("/{id}")
	public ToDo getOneById (@PathVariable("id") Long id) {
		return toDoService.findOne(id);
		
	}
	
	@PutMapping("/{id}")
	public ToDo edit(@PathVariable("id") Long id, @RequestBody ToDoDTO toDoDto) {
		String title = toDoDto.getTitle();
		String description = toDoDto.getDescription();
		Long priority = toDoDto.getPriorityId();
		Long user= toDoDto.getUserId();
		return toDoService.edit(id, title, description,priority,user);
	}
}

