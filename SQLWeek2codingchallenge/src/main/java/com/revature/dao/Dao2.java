package com.revature.dao;

import java.io.IOException;
import java.util.List;

import com.revature.beans.CDepartment;

public interface Dao2 {


		public List<CDepartment> getDepartment() throws IOException;
		public CDepartment getDepartmentById(int id) throws IOException;
		public void createDepartment(CDepartment department);
		public void updateDepartment(CDepartment department);
		public void deleteEmployee(CDepartment department);
		void deleteDepartment(CDepartment department);
		
	
}
