package com.example.spring.boot.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.boot.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
}
