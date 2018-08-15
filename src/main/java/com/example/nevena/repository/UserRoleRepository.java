package com.example.nevena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nevena.domain.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository < UserRole, Long>{
	
	UserRole findOneById(Long Id);

}
