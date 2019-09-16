package com.revature.main;

import java.io.IOException;

import com.revature.beans.Cave;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;

public class Driver {

	public static void main(String[] args) throws IOException {
		/*
		try {
			Connection conn = ConnectionUtil.getConnection();
			System.out.println(conn);
			System.out.println(conn.getMetaData().getDatabaseMajorVersion());
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		CaveDAO cd = new CaveDAOImpl();
		for (Cave c : cd.getCaves()) {
			System.out.println(c);
		}
		System.out.println(cd.getCaveById(1));
	}

}
