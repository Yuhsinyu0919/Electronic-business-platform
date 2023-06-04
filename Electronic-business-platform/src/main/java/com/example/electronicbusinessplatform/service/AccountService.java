package com.example.electronicbusinessplatform.service;

import com.example.electronicbusinessplatform.model.Account;

public interface AccountService {
	Account getAccountById(String accountid);
	void insertAccount(Account account);
	boolean getAccount(String accountid , String password);
}
