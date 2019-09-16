package com.revature.beans;

public class CDepartment {


	
	public CDepartment() {
		super();
	}
	public CDepartment(int DEPARTMENT_ID, String DEPARTMENT_NAME) {
		super();
		
		this.setDeptid(DEPARTMENT_ID);
		this.deptname = DEPARTMENT_NAME;
		
	}
	private int deptid;
	
	private String deptname;
	
	@Override
	public String toString() {
		return "dept_id=" + deptid + ", name=" + deptname ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDepartment other = (CDepartment) obj;
		if (deptid != other.deptid)
			return false;
		return true;
		
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	
}
