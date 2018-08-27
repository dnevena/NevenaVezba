package com.example.nevena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nevena.controller.dto.LoginDto;
import com.example.nevena.controller.dto.MessageDto;
import com.example.nevena.service.UserService;

@RestController
@RequestMapping("/authtentication")
public class AuthtenticationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public MessageDto login(@RequestBody LoginDto loginDto) {
		MessageDto messageDto = new MessageDto();
		
		if (userService.checkUser(loginDto.getUsername(), loginDto.getPassword()) ) {
			messageDto.setMessage("Uspesno");
		} else {
			messageDto.setMessage("nesupesno");
			
		}
		
		return messageDto;
	}

}
