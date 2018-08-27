package com.example.nevena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nevena.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	 User findOneById(Long id);
	 List<User>findAll();
	 User findOneByUsername(String username);
	
}
