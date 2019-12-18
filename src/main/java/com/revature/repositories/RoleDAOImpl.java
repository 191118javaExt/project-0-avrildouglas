package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Role;
import com.revature.util.ConnectionUtil;

public class RoleDAOImpl implements RoleDAO {

	private static Logger logger = Logger.getLogger(RoleDAOImpl.class);

	@Override
	public List<Role> findAll() {
		
		List<Role> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM roles;";

			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int id = rs.getInt("role_id");
				String role_title = rs.getString("role_title");
				int role_permit = rs.getInt("role_permit");
									
				Role r = new Role(id, role_title, role_permit);
					
				list.add(r);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all roles", e);
		}
		
		return list;		
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Role r) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO roles (role_title, role_permit) " +
					"VALUES (?, ?);";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, r.getRole_title());
			stmt.setInt(2, r.getRole_permit());
		
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to retrieve all roles", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Role r) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
