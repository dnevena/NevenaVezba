package com.example.nevena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.nevena.domain.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

	List<ToDo>findAll();
	ToDo findOneById(Long Id);
	
	
}
