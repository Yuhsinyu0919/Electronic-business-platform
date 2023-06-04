package com.example.electronicbusinessplatform.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.electronicbusinessplatform.model.Account;


public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet resultSet, int i) throws SQLException {
		Account account = new Account();
		account.setAccountid(resultSet.getString("accountid"));
		account.setPassword(resultSet.getString("password"));
		account.setSalt(resultSet.getString("salt"));
		account.setStatus(resultSet.getString("status"));
		account.setErrorcount(resultSet.getInt("errorcount"));
		account.setCreatetime(resultSet.getTimestamp("createtime"));
		account.setCreatetime(resultSet.getTimestamp("lastmodifiedtime"));
		 
		return account;
	}
	


}
