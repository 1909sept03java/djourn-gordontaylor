package com.revature.beans;

public class CEmployee {
	

	
	public CEmployee() {
		super();
	}
	public CEmployee(int EMPLOYEE_ID, String EMP_FIRSTNAME, String EMP_EMAIL,String EMP_LASTNAME,int DEPARTMENT_ID, double SALARY) {
		super();
		this.id = EMPLOYEE_ID;
		this.setDeptid(DEPARTMENT_ID);
		this.fname = EMP_FIRSTNAME;
		this.setLname(EMP_LASTNAME);
		this.salary = SALARY;
		this.setEmail(EMP_EMAIL);
	}
	private int id;
	private int deptid;
	private String fname;
	private String email;
	private String lname;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return fname;
	}
	public void setName(String name) {
		this.fname = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee emp_id=" + id + ", name=" + fname + ", salary=$" + salary ;
	}
	@Override
	public int hashCode() {
		final double prime = 31;
		double result = 1;
		result = prime * result + id;
		result = prime * result + salary;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		return (int) result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CEmployee other = (CEmployee) obj;
		if (id != other.id)
			return false;
		if (salary != other.salary)
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		return true;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}



}
