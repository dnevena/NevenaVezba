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

import com.example.nevena.controller.dto.PriorityDTO;
import com.example.nevena.domain.Priority;
import com.example.nevena.service.PriorityService;

@RestController
@RequestMapping("/priority")
public class PriorityController {

	@Autowired
	private PriorityService priorityService;
	
	
	@PostMapping("")
	public Priority createPriority(@RequestBody PriorityDTO priorityDto) {
		return priorityService.createPriority(priorityDto.getName());
		
	}
	

	@DeleteMapping("/{id}")
	public void  delete(@PathVariable("id") Long id) {
		priorityService.delete(id);
		
	}
	
	@GetMapping("")
	public List<Priority> getAll () {
		return priorityService.findAll();
		
	}

	@GetMapping("/{id}")
	public Priority getOneById (@PathVariable("id") Long id) {
		return priorityService.findOne(id);
		
	}
	
	@PutMapping("/{id}")
	public Priority edit(@PathVariable("id") Long id, @RequestBody PriorityDTO priorityDto) {
		String name = priorityDto.getName();
		
		return priorityService.edit(id, name);
	}
}

