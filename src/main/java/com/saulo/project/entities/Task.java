package com.saulo.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.saulo.project.entities.enums.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_task")
public class Task implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant createDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant initDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant finalDate;
	
	@ManyToOne
	@JoinColumn(name = "taskUser_id")
	private User taskUser;
	
	private Integer taskStatus;
	
	public Task() {
		
	}

	public Task(Long id, String title, String description, Instant createDate, Instant initDate,
			Instant finalDate, TaskStatus taskStatus, User taskUser) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.createDate = createDate;
		this.initDate = initDate;
		this.finalDate = finalDate;
		setTaskStatus(taskStatus);
		this.setTaskUser(taskUser);
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getCreateDate() {
		return createDate;
	}
	

	public Instant getInitDate() {
		return initDate;
	}

	public void setInitDate(Instant initDate) {
		this.initDate = initDate;
	}

	public Instant getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Instant finalDate) {
		this.finalDate = finalDate;
	}
	
	public TaskStatus getTaskStatus() {
		return TaskStatus.valueOf(taskStatus);
	}
	
	public void setTaskStatus(TaskStatus taskStatus) {
		if(taskStatus != null) {
			this.taskStatus = taskStatus.getCode();
		}
	}
	
	public User getTaskUser() {
		return taskUser;
	}

	public void setTaskUser(User taskUser) {
		this.taskUser = taskUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + "]";
	}
}
