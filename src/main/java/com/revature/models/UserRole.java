package com.revature.models;

public class UserRole {
	private int id;
	private String first_name;
	private String last_name;
	private String role_title;
	
	public UserRole() {
		super();
	}

	
	public UserRole(int id, String first_name, String last_name, String role_title) {
	super();
	
	this.id = id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.role_title = role_title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRole_title() {
		return role_title;
	}

	public void setRole_title(String role_title) {
		this.role_title = role_title;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
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
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
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
		return "UserRole [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", role_title="
				+ role_title + "]";
	}


	


}
	
	