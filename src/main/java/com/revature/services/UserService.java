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
	
	public boolean login(String username, String password) {
			//if(user_name == )		
		return false;
		
	}
	
	
	
}