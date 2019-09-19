package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.ACCOUNT;
import com.revature.beans.ACC_BALANCE;
import com.revature.beans.BANK_USER;
import com.revature.beans.Login;
import com.revature.dao.Dao;
import com.revature.dao.Dao2;
import com.revature.dao.Dao2impl;
import com.revature.dao.Daoimpl;

public class Driver {
	public static void main(String[] args) throws SQLException, IOException  {
		Scanner accin = new Scanner(System.in);
		String choice;
		System.out.println("Welcome to DGS Bank");

	    System.out.println("Do you have an account with us?");

	    System.out.println("enter : yes or no");
	    choice = accin.nextLine();


	    switch(choice)
	    {
	        case "yes":
	            Login login = new Login();
	            
	            break;

	        case "no":
	        	System.out.println("Alright. Let's set up an account for you");
	            
	            Daoimpl user = new Daoimpl();
	            BANK_USER users = user.createUser();
	            
	            Login nulogin = new Login(users);
	            
	            
	            break;

	        default:
	            System.out.println("please enter again ");
	            boolean repeat = true;

	            while (repeat)
	            {
	                System.out.println("Will this be a checking account? : yes or no");
	                choice = accin.nextLine();

	                switch (choice)
	                {
	                    case "yes":
	                    	 Login login2 = new Login();
	                        break;

	                    case "no":
	                    	System.out.println("Alright. Let's set up an account for you");
	                    	  Daoimpl user2 = new Daoimpl();
	          	            BANK_USER users2 = user2.createUser();
	          	            
	          	            Login nulogin2 = new Login(users2);
	                        break;
	                }
	            }
	            break;
	    }
		System.out.println("Thank you for banking with us");	
	}

	}


