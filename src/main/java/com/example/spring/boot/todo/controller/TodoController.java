package com.example.spring.boot.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.todo.entity.Todo;
import com.example.spring.boot.todo.service.TodoService;

@RestController
@RequestMapping(value="/todo")
public class TodoController {

	@Autowired
	private TodoService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Todo> add(@RequestBody Todo todo) {
		return ResponseEntity.ok(service.add(todo));
	}
}
