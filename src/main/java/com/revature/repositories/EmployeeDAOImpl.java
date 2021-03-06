package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;


public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);
	
@Override
	public List<Employee> findAll() {
		
		List<Employee> list = new ArrayList<>();
		List<Integer> supervisors = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM employees;";

			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String job_title = rs.getString("job_title");
				String email = rs.getString("email");
				double salary = rs.getDouble("salary");
				
				Employee e = new Employee(id, first_name, last_name, job_title, email, salary, null);
				int sup_id = rs.getInt("supervisor");
				
				list.add(e);
				supervisors.add(sup_id);
			}
			
			rs.close();
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all employees", e);
		}
		
		for(int i = 0; i < list.size(); i++) {
			int sup_id = supervisors.get(i);
			
			// Find Employee that matches supervisor id
			for(Employee e: list) {
				if(e.getId() == sup_id) {
					list.get(i).setSupervisor(e);
				}
			}
		}
		
		return list;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Employee e) {
		try (Connection conn = ConnectionUtil.getConnection()) {
	
			String sql = "INSERT INTO employee (first_name, last_name, email, job_title, salary, supervisor) " +
					"VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirst_name());
			stmt.setString(2, e.getLast_name());
			stmt.setString(3, e.getEmail());
			stmt.setDouble(4, e.getSalary());
			Employee sup = e.getSupervisor();
			
			if(sup != null) {
				stmt.setInt(5, sup.getId());

			} else {
				stmt.setNull(5, java.sql.Types.INTEGER);
			}
			
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
	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

}
