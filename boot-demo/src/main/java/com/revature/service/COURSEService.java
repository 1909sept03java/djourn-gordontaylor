package com.revature.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.COURSE;
import com.revature.model.COURSE;


@Service
public class COURSEService {

	static ArrayList<COURSE> courses = new ArrayList<>();
	static {
	

		//Initializing Data
		COURSE course1 = new COURSE(800,"Course1");
		COURSE course2 = new COURSE(801,"Course2");
		COURSE course3 = new COURSE(802,"Course3");
		COURSE course4 = new COURSE(803,"Course4");
courses.add(course1);
courses.add(course2);
courses.add(course3);
courses.add(course4);
	
	}


	public static ArrayList<COURSE> allCOURSEs() {
		return courses;
	}

	public COURSE getCOURSEbyId(int courseId) {
		for (COURSE course : courses) {
			if (course.getId() == courseId) {
				return course;
			}
		}
		return null;
	}


	public COURSE addCOURSE(COURSE course) {
		

	courses.add(course);

		return course;
	}
	public void deleteCOURSE(COURSE course) {
		

		courses.remove(course);

			
		}
	public COURSE addCOURSE(String coursename) {
		COURSE newcourse = new COURSE( coursename);

	courses.add(newcourse);

		return newcourse;
	}
	
}
