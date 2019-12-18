package com.revature.models;

public class UserRole {
	private int id;
	private String role_title;
	private int role_permit;
	
	public UserRole(int id, String role_title, int role_permit) {
		super();
		this.id = id;
		this.role_title = role_title;
		this.role_permit = role_permit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole_title() {
		return role_title;
	}

	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}

	public int getRole_permit() {
		return role_permit;
	}

	public void setRole_permit(int role_permit) {
		this.role_permit = role_permit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + role_permit;
		result = prime * result + ((role_title == null) ? 0 : role_title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (id != other.id)
			return false;
		if (role_permit != other.role_permit)
			return false;
		if (role_title == null) {
			if (other.role_title != null)
				return false;
		} else if (!role_title.equals(other.role_title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User_Roles [id=" + id + ", role_title=" + role_title + ", role_permit=" + role_permit + "]";
	}

	
	
	
	
	
	
}
