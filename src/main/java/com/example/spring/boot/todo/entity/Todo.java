package com.example.spring.boot.todo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String task;
	private boolean completed;
	
	@JsonFormat(pattern="dd-MM-yyyy'T'HH:mm:ss")
	private Date dueDate;
	
	public Todo() {
		super();
	}
	
	public Todo(String task, boolean completed, Date dueDate) {
		super();
		this.task = task;
		this.completed = completed;
		this.dueDate = dueDate;
	}
	
	public Integer getId() {
		return id;
	}

	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", task=" + task + ", completed=" + completed + ", dueDate=" + dueDate + "]";
	}
}
