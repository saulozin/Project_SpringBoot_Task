package com.saulo.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.saulo.project.entities.Task;
import com.saulo.project.entities.User;
import com.saulo.project.entities.enums.TaskStatus;
import com.saulo.project.repositories.TaskRepository;
import com.saulo.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//Anotation para injeção de dependência
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepository taskRepo;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Saulo", "saulo@email.com", "+55(99)99999-9999", "saulo", "password");
		User u2 = new User(null, "Jannaina", "janna@email.com", "+55(99)88888-8888", "janna", "password");
		
		Task t1 = new Task(null, "Tarefa 1", "Tarefa 1", Instant.parse("2023-06-30T10:00:00Z"), Instant.parse("2023-06-30T10:00:00Z"), 
				Instant.parse("2023-07-30T10:00:00Z"), TaskStatus.INPROGRESS, u1);
		
		Task t2 = new Task(null, "Tarefa 2", "Tarefa 2", Instant.parse("2023-06-30T10:00:00Z"), Instant.parse("2023-06-30T10:00:00Z"), 
				Instant.parse("2023-07-30T10:00:00Z"), TaskStatus.INPROGRESS, u2);
		
		userRepo.saveAll(Arrays.asList(u1, u2));
		taskRepo.saveAll(Arrays.asList(t1, t2));
	}
}
