package com.example.nevena.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.nevena.domain.User;
import com.example.nevena.repository.UserRepository;


public final class SecurityUtils {
	
	public SecurityUtils() {

	}

	public static Optional<String> getCurrentUserLoginByUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return Optional.ofNullable(securityContext.getAuthentication()).map(authentication -> {
			if (authentication.getPrincipal() instanceof UserDetails) {
				UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
				return springSecurityUser.getUsername();
			} else if (authentication.getPrincipal() instanceof String) {
				return (String) authentication.getPrincipal();
			}
			return null;
		});
	}

}