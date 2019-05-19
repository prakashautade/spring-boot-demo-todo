package com.example.spring.boot.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.boot.todo.entity.Todo;
import com.example.spring.boot.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;

	public Todo add(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public Optional<Todo> getById(int id) {
		return todoRepository.findById(id);
	}

	public void deleteById(int id) {
		todoRepository.deleteById(id);
	}
	
	public Optional<Todo> updateById(int id, Todo todo) {
		return getById(id).map(todoToUpdate -> {
			todoToUpdate.setTask(todo.getTask());
			todoToUpdate.setDueDate(todo.getDueDate());
			todoToUpdate.setCompleted(todo.isCompleted());
			return todoRepository.save(todoToUpdate);
		});
	}
	
	public List<Todo> getAll() {
		return todoRepository.findAll();
	}
}
