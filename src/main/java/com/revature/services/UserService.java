package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
//import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;

public class UserService {
	
	UserDAO repository = null;
	
	
	public UserService() {
		repository = new UserDAOImpl();
	}

	public UserService(UserDAO dao) {
		repository = dao;
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(User u) {
		return repository.insert(u);
	}
	
	public boolean update(User u) {
		return repository.update(u);
	}
	
	public boolean login(String password) {
		if ((password.length() < 8) || (password.length() > 12)) {	
			System.out.println("Password should be at least 8 characters but no more that 12. Please re-enter password: ");
			return false;
		} 
			return true;
	}	
}