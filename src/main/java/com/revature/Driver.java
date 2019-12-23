package com.revature;

import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.models.Transaction;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.repositories.RoleDAO;
import com.revature.repositories.RoleDAOImpl;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;
import com.revature.services.AccountService;
import com.revature.services.EmployeeService;
import com.revature.services.RoleService;
import com.revature.services.TransactionService;
import com.revature.services.UserRoleService;
import com.revature.services.UserService;



public class Driver {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		User u = new User();
		UserService us = new UserService();
		Account a = new Account();
		AccountService as = new AccountService();
		Employee e = new Employee();
		EmployeeService es = new EmployeeService();	
		Role r = new Role();
		RoleService rs = new RoleService();
		Transaction t = new Transaction();
		TransactionService ts = new TransactionService();
		UserRole ur = new UserRole();
		UserRoleService urs = new UserRoleService();
//		
//	
//		e.setJob_title("Engineer");
//		e.setFirst_name("Johny");
//		e.setEmail("abc@Johnny");
//		e.setSalary(100000);
//		
		
	
		 
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
//		String street, city, state;
		String pw; 
		int select;
//		String zip;
		
		System.out.print("Please select an option: ");
		select = sc.nextInt();
	
		switch (select) {
			case 1:
				System.out.print("Please enter your first name: ");
				fname = sc.next();
				u.setFirst_name(fname);
				System.out.print("Please enter your last name: ");
				lname = sc.next();
				u.setLast_name(lname);
				System.out.print("Please enter a username: ");
				username = sc.next();
				u.setUser_name(username);		
				System.out.print("Please enter a password: ");
				pw = sc.next();
				us.login(pw);
				u.setPassword(pw);
				us.insert(u);
				break;
			case 2:
				System.out.print("Please enter your username: ");
				username = sc.next();
				u.setUser_name(username);
				System.out.print("Please enter your password: ");
				pw = sc.next();
				us.login(pw);
				//us.update(u);
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
					break;				
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
				
		}
		
	}
