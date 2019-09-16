package com.revature.dao;


import java.io.IOException;
import java.util.List;

import com.revature.beans.CDepartment;
import com.revature.beans.CEmployee;


public interface Dao {

	public List<CEmployee> getEmployee() throws IOException;
	public CEmployee getEmployeeById(int id) throws IOException;
	public void createEmployee(CEmployee employee);
	public void updateEmployee(CEmployee employee);
	public void deleteEmployee(CEmployee employee);
	
}

