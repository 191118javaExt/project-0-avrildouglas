package com.revature.services;

import java.util.List;

import com.revature.models.Transaction;
import com.revature.repositories.TransactionDAO;
import com.revature.repositories.TransactionDAOImpl;

public class TransactionService {

	TransactionDAO repository = new TransactionDAOImpl();

	public List<Transaction> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(Transaction t) {
		return repository.insert(t);
	}
	
}

