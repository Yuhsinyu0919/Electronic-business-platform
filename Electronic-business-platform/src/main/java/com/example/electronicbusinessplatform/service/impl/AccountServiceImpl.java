package com.example.electronicbusinessplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.electronicbusinessplatform.dao.AccountDao;
import com.example.electronicbusinessplatform.model.Account;
import com.example.electronicbusinessplatform.service.AccountService;

@Component
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account getAccountById(String accountid) {
		
		return accountDao.getAccountById(accountid);
	}

	
	@Override
	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}


	@Override
	public boolean getAccount(String accountid, String password) {
		boolean result = accountDao.getAccount(accountid, password);
		return result;
	}


}
