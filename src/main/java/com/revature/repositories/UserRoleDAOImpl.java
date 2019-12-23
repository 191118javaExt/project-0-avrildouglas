package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.UserRole;
import com.revature.util.ConnectionUtil;

public class UserRoleDAOImpl implements UserRoleDAO{
	
	private static Logger logger = Logger.getLogger(UserRoleDAOImpl.class);

	@Override
	public List<UserRole> findAll() {
		List<UserRole> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user_roles;";

			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int id = rs.getInt("user_role_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String role_title = rs.getString("role_title");
									
				UserRole ur = new UserRole(id, first_name, last_name, role_title);
					
				list.add(ur);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all user roles", e);
		}
		
		return list;		
	}

	@Override
	public UserRole findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(UserRole ur) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO user_roles (first_name, last_name, role_title) " +
					"VALUES (?, ?, ?);";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ur.getFirst_name());
			stmt.setString(2, ur.getLast_name());
			stmt.setString(3, ur.getRole_title());
			
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to retrieve all users roles", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(UserRole ur) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
