package com.example.nevena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nevena.domain.Labela;
import com.example.nevena.domain.Priority;
import com.example.nevena.domain.ToDo;
import com.example.nevena.domain.User;
import com.example.nevena.repository.LabelaRepository;
import com.example.nevena.repository.PriorityRepository;
import com.example.nevena.repository.ToDoRepository;
import com.example.nevena.repository.UserRepository;

@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepository toDoRepository;
	
	@Autowired
	private PriorityRepository priorityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LabelaRepository labelaRepository;
	
	public ToDo createToDo (String title, String description, Long priorityId, Long userId, List<Long> labelaId) {
		ToDo toDo = new ToDo();
		toDo.setTitle(title);
		toDo.setDescription(description);
		Priority priority = priorityRepository.findOneById(priorityId);
		toDo.setPriority(priority);
		User user = userRepository.findOneById(userId);
		toDo.setUser(user);
		user.getLista().add(toDo);
		userRepository.save(user);
		
		for(Long l : labelaId) {
			Labela labela = labelaRepository.findOneById(l);
			toDo.getLabelaList().add(labela);
			labela.getTodoList().add(toDo);
			labelaRepository.save(labela);
		}
		return toDoRepository.save(toDo);
	}

	public void delete(Long id) {
		ToDo toDo = toDoRepository.findOneById(id);
		toDoRepository.delete(toDo);
		
	}
	
	public ToDo findOne(Long id) {
		 return toDoRepository.findOneById(id);
		
	}
	
	public List<ToDo> findAll () {
		return toDoRepository.findAll();
	}
	
	public ToDo edit (Long id, String title, String description, Long priorityId, Long userId) {
		ToDo toDo = toDoRepository.findOneById(id);
		toDo.setTitle(title);
		toDo.setDescription(description);
		Priority priority = priorityRepository.findOneById(priorityId);
		toDo.setPriority(priority);
		User user = userRepository.findOneById(userId);
		toDo.setUser(user);
		return toDoRepository.save(toDo);
	}

	
	
}
