package com.saulo.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.saulo.project.entities.Task;
import com.saulo.project.repositories.TaskRepository;
import com.saulo.project.services.exceptions.DatabaseException;
import com.saulo.project.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Task insert(Task obj) {
		return taskRepo.save(obj);
	}
	
	public void delete(Long id) {
		try {
			taskRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Task update(Long id, Task obj) {
		try {
			Task entity = taskRepo.getReferenceById(id);
			updateData(entity, obj);
			return taskRepo.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Task entity, Task obj) {
		entity.setTitle(obj.getTitle());
		entity.setDescription(obj.getDescription());
		entity.setInitDate(obj.getInitDate());
		entity.setFinalDate(obj.getFinalDate());
	}
}
