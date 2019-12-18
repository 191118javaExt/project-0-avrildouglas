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
				String role_title = rs.getString("role_title");
				int role_permit = rs.getInt("role_permit");
									
				UserRole r = new UserRole(id, role_title, role_permit);
					
				list.add(r);
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
			
			String sql = "INSERT INTO user_roles (role_title, role_permit) " +
					"VALUES (?, ?);";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ur.getRole_title());
			stmt.setInt(2, ur.getRole_permit());
			
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to retrieve all users", ex);
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
