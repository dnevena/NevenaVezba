package com.example.nevena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nevena.domain.Priority;

import com.example.nevena.repository.PriorityRepository;


@Service
public class PriorityService {
			
		@Autowired
		private PriorityRepository priorityRepository;
		
		
		public Priority createPriority (String name) {
			Priority priority= new Priority();
			priority.setName(name);
			
			return priorityRepository.save(priority);
		
		}

		public void delete(Long id) {
			Priority priority = priorityRepository.findOneById(id);
			priorityRepository.delete(priority);
			
		}
		
		public Priority findOne(Long id) {
			 return priorityRepository.findOneById(id);
			
		}
		
		public List<Priority> findAll () {
			return priorityRepository.findAll();
		}
		
		public Priority edit (Long id, String name) {
			Priority priority = priorityRepository.findOneById(id);
			priority.setName(name);
			
			return priorityRepository.save(priority);
		}

		
		
	}


