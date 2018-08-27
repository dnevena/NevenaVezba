package com.example.nevena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nevena.domain.Role;
import com.example.nevena.domain.User;
import com.example.nevena.domain.UserRole;
import com.example.nevena.repository.RoleRepository;
import com.example.nevena.repository.UserRepository;
import com.example.nevena.repository.UserRoleRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	public User createUser(String username, String password, String email, List<Long> userRoleId) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		userRepository.save(user);
		for (Long l : userRoleId) {
			Role role = roleRepository.findOneById(l);
			UserRole userRole  = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			
			userRoleRepository.save(userRole);
		}
		
	    return user; 
		
		
	}

	public void deleteUser (Long id){
		User user = userRepository.findOneById(id);
		userRepository.delete(user);
		
	}
	
	public User findOne (Long id) {
		User user = userRepository.findOneById(id);
		
		return user;
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User editUser(Long id, String username, String password, String email) {
		User user = userRepository.findOneById(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		return userRepository.save(user);
		
		
	}
	
	public boolean checkUser (String username, String password) {
		
		User user = userRepository.findOneByUsername(username);
		boolean valid = false;
		if (user!= null ) {
			if(user.getPassword().equals(password)) {
				valid = true;
			}
		}
		
		return valid;
		
	}	
}
