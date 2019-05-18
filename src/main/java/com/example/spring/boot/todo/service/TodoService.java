package com.example.spring.boot.todo.service;

import java.util.List;

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
	
	public Todo getById(int id) {
		return todoRepository.getOne(id);
	}

	public void deleteById(int id) {
		todoRepository.deleteById(id);
	}
	
	public Todo updateById(int id, Todo todo) {
		Todo updatedTodo = getById(id);
		updatedTodo.setCompleted(todo.isCompleted());
		updatedTodo.setDueDate(todo.getDueDate());
		updatedTodo.setTask(todo.getTask());
		return todoRepository.save(updatedTodo);
	}
	
	public List<Todo> getAll() {
		return todoRepository.findAll();
	}
}
