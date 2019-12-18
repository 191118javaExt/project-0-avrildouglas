package com.revature.models;

import java.util.Date;

public class Transaction {
	
	private int id;
	private String trans_type;
	private double trans_amount;
	private Date trans_date;
	
	public Transaction(int id, String trans_type, double trans_amount, Date trans_date) {
		super();
		this.id = id;
		this.trans_type = trans_type;
		this.trans_amount = trans_amount;
		this.trans_date = trans_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrans_type() {
		return trans_type;
	}

	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}
	
	public Double getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(Double trans_amount) {
		this.trans_amount = trans_amount;
	}

	public Date getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(Date trans_date) {
		this.trans_date = trans_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((trans_date == null) ? 0 : trans_date.hashCode());
		result = prime * result + ((trans_type == null) ? 0 : trans_type.hashCode());
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
		Transaction other = (Transaction) obj;
		if (id != other.id)
			return false;
		if (trans_date == null) {
			if (other.trans_date != null)
				return false;
		} else if (!trans_date.equals(other.trans_date))
			return false;
		if (trans_type == null) {
			if (other.trans_type != null)
				return false;
		} else if (!trans_type.equals(other.trans_type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", trans_type=" + trans_type + ", trans_date=" + trans_date + "]";
	}	
}
