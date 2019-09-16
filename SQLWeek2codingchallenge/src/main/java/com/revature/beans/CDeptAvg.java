package com.revature.beans;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.util.ConnectionUtil;

public class CDeptAvg {
	private static Connection con;

	public static double getAVG(int id) {
		double avg = 0;
		// try-with-resources... resources included in the try args will be closed at
		// the end of the block
		// works with all AutoCloseable resources
		try (Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties")) {
			String sql = "SELECT AVG(B.SALARY) AS AVGSALARY FROM CDEPARTMENT A INNER JOIN CEMPLOYEE B ON A.DEPARTMENT_ID = B.DEPARTMENT_ID WHERE A.DEPARTMENT_ID = ? GROUP BY A.DEPARTMENT_ID";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				avg = rs.getInt("AVGSALARY");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return avg;
	}

	public static void SetAvg(int department_id) throws SQLException, IOException {
		con = ConnectionUtil.getConnection("src\\main\\java\\connection.properties");
		float AVG_SALARY = 0;
		CallableStatement cstmt = con.prepareCall("{call SP_GIVE_RAISE(?, ?)}");
		cstmt.setInt(1, department_id);
		cstmt.registerOutParameter(2, Types.FLOAT);
		cstmt.setFloat(2, AVG_SALARY);

		cstmt.executeQuery();
		System.out.println("Salaries Increased");

	}
}
