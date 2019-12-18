package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {
	
	private static Logger logger = Logger.getLogger(AccountDAOImpl.class);	

	@Override
	public List<Account> findAll() {
		
		List<Account> list = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts;";

			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int account_id = rs.getInt("account_id");
				String account_descrip = rs.getString("account_descrip");
			
				
				Account a = new Account(account_id, account_descrip);
			
				
				list.add(a);
		
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all accounts", e);
		}
		
		return list;
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Account a) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO accounts (account_descrip) " +
					"VALUES (?);";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, a.getAccount_descrip());
	
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to retrieve all accounts", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

}
