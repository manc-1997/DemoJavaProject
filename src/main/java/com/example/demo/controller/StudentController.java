package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@RestController
public class StudentController {
    
	@Autowired(required=true)
	StudentRepo studentService;
	
	public ResponseEntity<Student> addUser(@RequestBody Student student) {
		studentService.save(student);
		final var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
