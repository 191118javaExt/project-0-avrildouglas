package com.revature.services;

import java.util.List;

import com.revature.models.Account;
import com.revature.repositories.AccountDAO;
import com.revature.repositories.AccountDAOImpl;

public class AccountService {
	AccountDAO repository = new AccountDAOImpl();

	public List<Account> findAll() {
		return repository.findAll();
	}
	
	public boolean insert(Account a) {
		return repository.insert(a);
	}
}


