package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CDepartment;
import com.revature.beans.CEmployee;

import com.revature.util.connectionUtil;

public class Dao2impl implements Dao2{
	
	@Override
	public List<CDepartment> getDepartment() {
		List<CDepartment> cl = new ArrayList<>();
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = connectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM CDEPARTMENT";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				int DEPARTMENT_ID = rs.getInt("DEPARTMENT_ID");
				
				String DEPARTMENT_NAME = rs.getString("DEPARTMENT_NAME");
				
				cl.add(new CDepartment(DEPARTMENT_ID, DEPARTMENT_NAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return cl;
	}

	@Override
	public CDepartment getDepartmentById(int id) {
		CDepartment c = null;
		// try-with-resources... resources included in the try args will be closed at the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = connectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT * FROM CDEPARTMENT WHERE DEPARTMENT_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int DEPARTMENT_ID = rs.getInt("DEPARTMENT_ID");
				String DEPARTMENT_NAME = rs.getString("DEPARTMENT_NAME");
				c = new CDepartment(DEPARTMENT_ID, DEPARTMENT_NAME);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return c;
	}

	@Override
	public void createDepartment(CDepartment department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDepartment(CDepartment department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDepartment(CDepartment department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(CDepartment department) {
		// TODO Auto-generated method stub
		
	}
}