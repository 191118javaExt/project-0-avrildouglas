package com.revature.services;

import java.util.List;
import com.revature.models.UserRole;
import com.revature.repositories.UserRoleDAO;
import com.revature.repositories.UserRoleDAOImpl;

public class UserRoleService {

	UserRoleDAO repository = new UserRoleDAOImpl();

	public List<UserRole> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(UserRole ur) {
		return repository.insert(ur);
	}
}

