package com.revature.repositories;

import java.util.List;

import com.revature.models.Role;

public interface RoleDAO {

		public List<Role> findAll();
		public Role findById(int id);
		public boolean insert(Role r);
		public boolean update(Role r);
}



