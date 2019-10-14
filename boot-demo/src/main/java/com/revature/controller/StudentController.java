package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Student;
import com.revature.model.COURSE;
import com.revature.service.StudentService;

@RestController 
@RequestMapping(value = "/Student")
public class StudentController {

	private StudentService StudentService;

	@Autowired 
	public void setStudentService(StudentService StudentService) {
		this.StudentService = StudentService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<>(this.StudentService.allStudents(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student f = this.StudentService.getStudentbyId(id);
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST) 
	public ResponseEntity<Student> UpdateStudentById(@PathVariable int id,String name) {
		Student f = this.StudentService.getStudentbyId(id);
		
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			
			this.StudentService.deleteStudent(f);
			f.setname(name);
			this.StudentService.addStudent(f);
			
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST) // parameterize the path
	public ResponseEntity<Student> deleteStudentById(@PathVariable int id,String name) {
		Student f = this.StudentService.getStudentbyId(id);
		
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			
		this.StudentService.deleteStudent(f);
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	
	

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentByIdWithQueryString(@RequestParam int id) {
		Student f = this.StudentService.getStudentbyId(id);
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@Valid @RequestBody Student Student) {
		ResponseEntity<String> resp = null;
		try {
			this.StudentService.addStudent(Student);
			resp = new ResponseEntity<>("Student CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO CREATE Student", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
