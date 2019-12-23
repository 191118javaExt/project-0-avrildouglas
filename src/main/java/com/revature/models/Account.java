package com.revature.models;

public class Account {
	private int account_id;
	private String account_num;
	private Double account_bal;
	private String account_descrip;
	

	public Account() {
		super();

	}

	public Account(int account_id, String account_num, Double account_bal, String account_descrip) {
		super();
		
		this.account_id = account_id;
		this.account_num = account_num;
		this.account_bal = account_bal;
		this.account_descrip = account_descrip;
	
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public Double getAccount_bal() {
		return account_bal;
	}

	public void setAccount_bal(Double account_bal) {
		this.account_bal = account_bal;
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
		result = prime * result + ((account_bal == null) ? 0 : account_bal.hashCode());
		result = prime * result + ((account_descrip == null) ? 0 : account_descrip.hashCode());
		result = prime * result + account_id;
		result = prime * result + ((account_num == null) ? 0 : account_num.hashCode());
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
		if (account_bal == null) {
			if (other.account_bal != null)
				return false;
		} else if (!account_bal.equals(other.account_bal))
			return false;
		if (account_descrip == null) {
			if (other.account_descrip != null)
				return false;
		} else if (!account_descrip.equals(other.account_descrip))
			return false;
		if (account_id != other.account_id)
			return false;
		if (account_num == null) {
			if (other.account_num != null)
				return false;
		} else if (!account_num.equals(other.account_num))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_num=" + account_num + ", account_bal=" + account_bal
				+ ", account_descrip=" + account_descrip + "]";
	}

}


	
	
	
	

	
