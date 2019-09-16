package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.CDepartment;
import com.revature.beans.CDeptAvg;
import com.revature.beans.CEmployee;

import com.revature.dao.Dao;
import com.revature.dao.Dao2;
import com.revature.dao.Dao2impl;
import com.revature.dao.Daoimpl;

public class Driver {
	public static void main(String[] args)  {
		try {
//		String filename = "src/main/resources/connection.properties";
//    Connection conn = connectionUtil.getConnection(filename);
//    System.out.println(conn);
			Dao cd = new Daoimpl();
			Dao2 dc = new Dao2impl();
			for (CEmployee c : cd.getEmployee()) {
				System.out.println(c);
			}
			for (CDepartment d : dc.getDepartment()) {
				System.out.println(d);
			}
			System.out.println(cd.getEmployeeById(1));
			System.out.println(dc.getDepartmentById(10000));
			System.out.println(CDeptAvg.getAVG(10001));
			CDeptAvg.SetAvg(10001);
			System.out.println(CDeptAvg.getAVG(10001));
		}

		catch (Exception e) {

		}

	}

}
