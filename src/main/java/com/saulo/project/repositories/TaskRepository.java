package com.saulo.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saulo.project.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
