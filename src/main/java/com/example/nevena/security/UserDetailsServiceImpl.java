package com.example.nevena.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.nevena.domain.User;
import com.example.nevena.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(final String username) {
		User userByUsernameFromDatabase = userRepository.findOneByUsername(username);
	
		if (userByUsernameFromDatabase == null) {
			throw new UsernameNotFoundException(
				"User" + userByUsernameFromDatabase.getUsername() + "was not found in the" + "database");					
		
		}
		return createSpringSecurityUser(userByUsernameFromDatabase);
		
	}
	
	private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {
		
		List<GrantedAuthority> grantedAuthorities= new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),grantedAuthorities);
	}

}
