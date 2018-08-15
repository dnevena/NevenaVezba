package com.example.nevena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nevena.domain.Priority;
import com.example.nevena.domain.ToDo;



@Repository
public interface PriorityRepository extends JpaRepository<Priority, Integer>{
	
	List<Priority>findAll();
	Priority findOneById(Long id);
}
