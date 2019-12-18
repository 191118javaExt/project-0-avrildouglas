package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Transaction;

import com.revature.util.ConnectionUtil;

public class TransactionDAOImpl implements TransactionDAO {
	
	private static Logger logger = Logger.getLogger(TransactionDAOImpl.class);

	@Override
	public List<Transaction> findAll() {
		List<Transaction> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM transactions;";

			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int id = rs.getInt("trans_id");
				String trans_type = rs.getString("trans_type");
				Double trans_amount = rs.getDouble("trans_amount");
				Date trans_date = rs.getDate("trans_date");
		
							
				Transaction t = new Transaction(id, trans_type, trans_amount, trans_date);
					
				list.add(t);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all transactions", e);
		}
		
		return list;		
	}

	@Override
	public Transaction findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Transaction t) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO transactions (trans_type, trans_amount, trans_date) " +
					"VALUES (?, ?, ?);";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(2, t.getTrans_type());
			stmt.setDate(3, (java.sql.Date) t.getTrans_date());
			
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to retrieve all transactions", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Transaction t) {
		// TODO Auto-generated method stub
		return false;
	}

}
