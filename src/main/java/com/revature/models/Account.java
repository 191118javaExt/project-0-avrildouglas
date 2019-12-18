package com.revature.models;

public class Account {
	private int account_id;
	private String account_descrip;

	public Account(int account_id, String account_descrip) {
		super();
		this.account_id = account_id;
		this.account_descrip = account_descrip;
	}


	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public String getAccount_descrip() {
		return account_descrip;
	}


	public void setAccount_descrip(String account_descrip) {
		this.account_descrip = account_descrip;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_descrip == null) ? 0 : account_descrip.hashCode());
		result = prime * result + account_id;
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
		Account other = (Account) obj;
		if (account_descrip == null) {
			if (other.account_descrip != null)
				return false;
		} else if (!account_descrip.equals(other.account_descrip))
			return false;
		if (account_id != other.account_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_descrip=" + account_descrip + "]";
	}
}
	
	
	
	
	
	

	
