package com.revature.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class BANK_USER {
	

	

	public BANK_USER(int USER_ID, String USER_FIRSTNAME,String USER_LASTNAME,int ACCOUNT_ID,String USER_NAME) {
		super();
		this.id = USER_ID;
		this.setAccid(ACCOUNT_ID);
		this.setUserName(USER_NAME);
		
		this.fname = USER_FIRSTNAME;
		this.lname = USER_LASTNAME;
		
	
	}
	private int id;
	private int accid;
	private String fname;
	private String lname;
	private String userName;

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
	
	@Override
	public String toString() {
		return "Employee emp_id=" + id + ", name=" + fname + " " + lname + ", acc#=" + accid ;
	}
	@Override
	public int hashCode() {
		final double prime = 31;
		double result = 1;
		result = prime * result + id;
		
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
		BANK_USER other = (BANK_USER) obj;
		if (id != other.id)
			return false;
		
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		return true;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

public void CheckBalance() {
	
	
	
	ACC_BALANCE.getBalance(accid);
}

public void Deposit(int ACCOUNT_ID) throws SQLException, IOException{
	
	Scanner dep = new Scanner(System.in);
	System.out.println("How much would you like to deposit?");
	float deposit = dep.nextFloat();
	ACC_BALANCE.DepositBalance(deposit, ACCOUNT_ID);
	
}


public void Withdraw(int ACCOUNT_ID) throws SQLException, IOException{
	
	Scanner dep = new Scanner(System.in);
	System.out.println("How much would you like to Withdraw?");
	float withdrawal = dep.nextFloat();
	ACC_BALANCE.withdrawBalance(withdrawal, ACCOUNT_ID);
	
}


}
