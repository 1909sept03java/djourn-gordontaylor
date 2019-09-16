package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CEmployee;

import com.revature.util.connectionUtil;

public class Daoimpl implements Dao{
	
	@Override
	public List<CEmployee> getEmployee() {
		List<CEmployee> cl = new ArrayList<>();
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = connectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM CEMPLOYEE";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int EMPLOYEE_ID = rs.getInt("EMPLOYEE_ID");
				String EMP_FIRSTNAME = rs.getString("EMP_FIRSTNAME");
				String EMP_EMAIL = rs.getString("EMP_EMAIL");
				String EMP_LASTNAME = rs.getString("EMP_LASTNAME");
				int DEPARTMENT_ID = rs.getInt("DEPARTMENT_ID");
				double salary = rs.getInt("SALARY");
				cl.add(new CEmployee(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_EMAIL,EMP_LASTNAME,DEPARTMENT_ID,salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return cl;
	}

	@Override
	public CEmployee getEmployeeById(int id) {
		CEmployee c = null;
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = connectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM CEMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int EMPLOYEE_ID = rs.getInt("EMPLOYEE_ID");
				String EMP_FIRSTNAME = rs.getString("EMP_FIRSTNAME");
				String EMP_EMAIL = rs.getString("EMP_EMAIL");
				String EMP_LASTNAME = rs.getString("EMP_LASTNAME");
				int DEPARTMENT_ID = rs.getInt("DEPARTMENT_ID");
				double salary = rs.getInt("SALARY");
				c = new CEmployee(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_EMAIL,EMP_LASTNAME,DEPARTMENT_ID,salary);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return c;
	}

	@Override
	public void createEmployee(CEmployee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(CEmployee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(CEmployee employee) {
		// TODO Auto-generated method stub
		
	}
}
