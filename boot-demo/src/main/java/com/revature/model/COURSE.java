package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="COURSE")
public class COURSE {
	
	public COURSE() {
		super();
	}
	public COURSE(String name) {
		super();
		this.name = name;
		
		
	}
	public COURSE(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
		
	}
	
	@Min(0) 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="COURSESequence")
	@SequenceGenerator(allocationSize=1, name="COURSESequence", sequenceName="SQ_COURSE_PK")
	@Column(name="COURSE_ID")
	private int id;
	
	@NotEmpty
	@Column(name="name")
	private String name;

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


	


}