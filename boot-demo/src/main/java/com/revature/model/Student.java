package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	
	public Student(int id, String name, ArrayList<COURSE> courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}
	public Student(String name, ArrayList<COURSE> courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	public Student() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="studentSequence")
	@SequenceGenerator(allocationSize=1, name="studentSequence", sequenceName="SQ_STUDENT_PK")
	@Column(name="STUDENT_ID")
	private int id;
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="COURSE_STUDENT",
			joinColumns = {@JoinColumn(name="STUDENT_ID")},
			inverseJoinColumns = {@JoinColumn(name="COURSE_ID")})
	private List<COURSE> courses = new ArrayList<>();
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
	public List<COURSE> getcourses() {
		return courses;
	}
	public void setcourses(List<COURSE> courses) {
		this.courses = courses;
	}
	

}
