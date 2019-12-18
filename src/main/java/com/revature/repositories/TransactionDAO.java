package com.revature.repositories;

import java.util.List;

import com.revature.models.Transaction;

public interface TransactionDAO {

		public List<Transaction> findAll();
		public Transaction findById(int id);
		public boolean insert(Transaction t);
		public boolean update(Transaction t);
	}
