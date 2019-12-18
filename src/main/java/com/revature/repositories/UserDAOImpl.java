package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
@Override
	public List<User> findAll() {
		
		List<User> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM user;";

			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String user_name = rs.getString("user_name");
				int password = rs.getInt("password");
							
				User u = new User(id, first_name, last_name, user_name, password);
					
				list.add(u);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}
		
		return list;		
	}
		

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {
	
			String sql = "INSERT INTO user (user_name, first_name, last_name, password) " +
					"VALUES (?, ?, ?, ?);";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(2, u.getFirst_name());
			stmt.setString(3, u.getLast_name());
			stmt.setString(1, u.getUser_name());
			stmt.setInt(4, u.getPassword());
			
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
	public boolean update(User e) {
		// TODO Auto-generated method stub
			return false;
		}

	}

