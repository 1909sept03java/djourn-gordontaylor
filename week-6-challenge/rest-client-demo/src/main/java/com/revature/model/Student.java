package com.revature.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Student {

	public Student() {
		super();
	}

	public Student(String name,  courses courses) {
		super();
		this.name = name;
		
		this.courses = courses;
	}

	public Student(int id, String name, courses courses) {
		super();
		this.id = id;
		this.name = name;
	
		this.courses = courses;
	}

	@Min(0) // JSR303 validation
	private int id;
	@NotEmpty // JSR303 validation
	private String name;

	@NotNull // JSR303 validation
	private courses courses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getAnswer() {
		return answer;
	}

	

	public courses getcourses() {
		return courses;
	}

	public void setcourses(courses courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name +", courses=" + courses + "]";
	}
}