package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.client.StudentClient;
import com.revature.model.Student;

@RestController
public class StudentClientTestController {
	
	private StudentClient StudentClient;
	
	@Autowired
	public void setStudentClient(StudentClient StudentClient) {
		this.StudentClient = StudentClient;
	}
	
	@GetMapping(value="/testGetAllStudents")
	public ResponseEntity<List<Student>> testGetAllStudents() {
		return new ResponseEntity<>(this.StudentClient.getStudents(), HttpStatus.OK);
	}

}
