package com.saulo.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saulo.project.entities.Task;
import com.saulo.project.repositories.TaskRepository;

//Anotation para registrar a classe no mecanismo de injeção de dependência.
@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	public List<Task> findAll(){
		return taskRepo.findAll();
	}
	
	public Task findById(Long id) {
		Optional<Task> obj = taskRepo.findById(id);
		return obj.get();
	}
	
	public Task insert(Task obj) {
		return taskRepo.save(obj);
	}
	
	public void delete(Long id) {
		taskRepo.deleteById(id);
	}
	
	public Task update(Long id, Task obj) {
		Task entity = taskRepo.getReferenceById(id);
		updateData(entity, obj);
		return taskRepo.save(entity);
	}
	
	private void updateData(Task entity, Task obj) {
		entity.setTitle(obj.getTitle());
		entity.setDescription(obj.getDescription());
		entity.setInitDate(obj.getInitDate());
		entity.setFinalDate(obj.getFinalDate());
	}
}
