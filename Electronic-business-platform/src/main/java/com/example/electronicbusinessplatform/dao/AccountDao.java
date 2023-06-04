package com.example.electronicbusinessplatform.dao;

import com.example.electronicbusinessplatform.model.Account;

public interface AccountDao {

	Account getAccountById(String accountid);
	boolean getAccount(String accountid , String password);
	void insertAccount(Account account);
}
