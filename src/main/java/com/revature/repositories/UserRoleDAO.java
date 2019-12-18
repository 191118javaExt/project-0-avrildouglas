package com.revature.repositories;

import java.util.List;

import com.revature.models.UserRole;

public interface UserRoleDAO {

		public List<UserRole> findAll();
		public UserRole findById(int id);
		public boolean insert(UserRole ur);
		public boolean update(UserRole ur);
		}


