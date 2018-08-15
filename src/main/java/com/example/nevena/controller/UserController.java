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
import com.example.nevena.controller.dto.UserDTO;
import com.example.nevena.domain.User;
import com.example.nevena.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("")
	public User createUser(@RequestBody UserDTO userDto) {
		return userService.createUser(userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), userDto.getUserRoleId());
	}

	@DeleteMapping("/{id}")
	public void delete (@PathVariable ("id") Long id) {
		userService.deleteUser(id);
	}
	

	@GetMapping("{/id}")
	public User findOne(@PathVariable ("id") Long id) {
		return userService.findOne(id);
	}
	
	@GetMapping()
	public List<User>findAll() {
		return userService.findAll();
	}
	

	@PutMapping("/edit")
	public User editUser(@PathVariable("id") Long id, @RequestBody UserDTO userDto) {
		String username = userDto.getUsername();
		String password = userDto.getPassword();
		String email = userDto.getEmail();
		
		return userService.editUser(id,username,password,email);
	} 

	
	
}



