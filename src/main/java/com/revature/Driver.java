package com.revature;

import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.RoleDAO;
import com.revature.repositories.RoleDAOImpl;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;
import com.revature.services.UserService;



public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		 
		System.out.println("**********************************BANK OF AMERICA ATM*********************************");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*        		       	1. Register (First Time)                             *");                                                                      
		System.out.println("*        		       	2. Login                                             *");                      
		System.out.println("*        		       	3. Exit                                              *");                                             
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("**************************************************************************************");
		System.out.println();
		System.out.println();
		System.out.println();
	
		
		String user, pass;
		String fname, lname, username;
		int pw, select;
		
		System.out.print("Please select an option: ");
		select = sc.nextInt();
	
		switch (select) {
			case 1:
				System.out.print("Please enter your first name: ");
				fname = sc.next();
				System.out.print("Please enter your last name: ");
				lname = sc.next();
				System.out.print("Please enter a username: ");
				username = sc.next();
				System.out.print("Please enter a 5 digit pin: ");
				pw = sc.nextInt();
//				User u = new User(0,fname, lname,username,pw);
//				UserService us =new UserService();
//				us.insert(u);
				break;
			case 2:
				System.out.print("Please enter your username: ");
				username = sc.next();
				System.out.print("Please enter your password: ");
				pw = sc.nextInt();
//				User u = new User(0, username, pw);
//				UserService us =new UserService();
//				us.update(u);
				
				System.out.println("Log in successful");
				

		        break;
		        
			case 3:
				System.exit(0);
	       
			default : break;
			}
			
		
		System.out.println("**********************************BANK OF AMERICA ATM*********************************");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*        		       	1. Deposit Funds                                     *");                                                                      
		System.out.println("*        		       	2. Withdraw Funds                                            *");                      
		System.out.println("*        		       	3. Transfer Funds                                            *");                                             
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("*                                                                                    *");
		System.out.println("**************************************************************************************");
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		
				System.out.print("Please select an option: ");
				select = sc.nextInt();
				
				double depamt, witamt;
				double initialBal = 1000.00;
	
				double currentBal;
				
				switch (select) {
				case 1:
					System.out.print("You have chosen to make a deposit.");
					System.out.print("Please enter the deposit amount: ");
					depamt = sc.nextDouble();
					depamt = initialBal + depamt;
					System.out.print("Your current balance is now "+ depamt);

					//break;
					
				case 2:
					System.out.print("Please enter the withdrawal amount: ");
					witamt = sc.nextDouble();
					System.out.print("You have chosen to make a withdrawal ");
					currentBal = initialBal - witamt;
					System.out.print("Your current balance is now "+ currentBal);
					break;
				
				case 3:
					System.out.println("This option is not currently available");
				}
				
		1}
		
	}
