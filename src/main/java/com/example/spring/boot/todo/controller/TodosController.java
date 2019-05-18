package com.example.spring.boot.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.todo.entity.Todo;
import com.example.spring.boot.todo.service.TodoService;

@RestController
@RequestMapping(value="/todos")
public class TodosController {

	@Autowired
	private TodoService service;

	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Todo>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Todo> getById(@PathVariable("id") int id) { 
		return ResponseEntity.ok(service.getById(id)); 
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") int id) {
		service.deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Todo> updateById(@PathVariable int id, @RequestBody Todo todo) {
		return ResponseEntity.ok(service.updateById(id, todo));
	}
	
}
