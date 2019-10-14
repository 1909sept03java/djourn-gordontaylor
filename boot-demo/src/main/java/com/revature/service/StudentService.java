package com.revature.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.COURSE;
import com.revature.model.Student;

import com.revature.repository.StudentRepository;

@Service
public class StudentService {
	
	static ArrayList<COURSE> courses = COURSEService.allCOURSEs();
	static List<Student> students = new ArrayList<>();

	static {
	


		Student Emilie = new Student(1, "Emilie",courses);


		Student DJ = new Student( 2,"DJ", courses);

		students.add(Emilie);
		students.add(DJ);
	}


	public List<Student> allStudents() {
		return students;
	}

	public Student getStudentbyId(int studentId) {
		for (Student student : students) {
			if (student.getId() == studentId) {
				return student;
			}
		}
		return null;
	}

	public List<COURSE> getCourses(int studentId) {
		Student student = getStudentbyId(studentId);
		
	
		if (student == null) {
			return null;
		}

		return student.getcourses();
	}
	public Student addStudent(Student student) {
		

	students.add(student);

		return student;
	}
	public void deleteStudent(Student student) {
		

		students.remove(student);

			
		}
	public Student addStudent(String student) {
		Student newstudent = new Student( student, courses);

	students.add(newstudent);

		return newstudent;
	}
	
}
