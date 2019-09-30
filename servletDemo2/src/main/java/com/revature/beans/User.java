package com.revature.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {

	public User(int USER_ID, String NAME,String LastName,String PASSWORD,String isAdmin) {
		super();
		 this.id = USER_ID;
		 this.firstName = NAME;
		 this.lastName = LastName;
		 this.setAdmin(isAdmin);
		 this.password = PASSWORD;
		 
		
	}

	private int id;
	private int accid;
	private String firstName;
	private String lastName;
	private String password;
	private String userName;
	private String admin;
	private Scanner dep;
	private Scanner dep2;

	

	public void CheckBalance() {

		ACC_BALANCE.getBalance(accid);
	}

	public void Deposit(int ACCOUNT_ID) throws SQLException, IOException {

		dep2 = new Scanner(System.in);
		float deposit = 0;
		boolean isfloat = false;

		while (isfloat == false) {
			try {
				System.out.println("How much would you like to deposit?");
				String tempdep = dep2.nextLine();
				deposit = Float.parseFloat(tempdep);
				isfloat = true;
			} catch (InputMismatchException d) {

			} catch (NumberFormatException e) {
			}
		}

		ACC_BALANCE.DepositBalance(deposit, ACCOUNT_ID);

	}

	public void Withdraw(int ACCOUNT_ID) throws SQLException, IOException {

		dep = new Scanner(System.in);

		float withdrawal = 0;
		boolean isfloat = false;
		while (isfloat == false) {
			try {
				System.out.println("How much would you like to Withdraw?");
				String tempwith = dep.nextLine();
				withdrawal = Float.parseFloat(tempwith);
				isfloat = true;
			} catch (InputMismatchException d) {

			} catch (NumberFormatException e) {
			}
		}
		ACC_BALANCE.withdrawBalance(withdrawal, ACCOUNT_ID);

	}

	public Object getLastname() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public Object getFirstname() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
