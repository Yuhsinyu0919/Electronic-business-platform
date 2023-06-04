package com.example.electronicbusinessplatform.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.example.electronicbusinessplatform.rowmapper.AccountRowMapper;
import com.example.electronicbusinessplatform.dao.AccountDao;
import com.example.electronicbusinessplatform.model.Account;

@Component
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Account getAccountById(String accountid) {
		String sql = "SELECT accountid, password,salt,status,errorcount,createtime,lastmodifiedtime "
				   + " FROM account where accountid = :accountid";
		Map<String, Object> map= new HashMap<>();
		map.put("accountid", accountid);
		List<Account> accountList = namedParameterJdbcTemplate.query(sql, map, new AccountRowMapper());
		
		if(accountList.size() > 0) {
			return accountList.get(0);
		}else {
			return null;
		}
		
	}
	
	@Override
	public boolean getAccount(String accountid, String password) {
		String sql = "SELECT accountid, password,salt,status,errorcount,createtime,lastmodifiedtime "
				   + " FROM account where accountid = :accountid AND password = :password";
		Map<String, Object> map= new HashMap<>();
		map.put("accountid", accountid);
		map.put("password", password);
		List<Account> accountList = namedParameterJdbcTemplate.query(sql, map, new AccountRowMapper());
System.out.print("46 accountList.size=()"+accountList.size());
		if(accountList.size() > 0 ) {
			return true;
		}else {
			return false;
		}

	}
	
	@Override
	public void insertAccount(Account account) {
		
		String sql = "INSERT INTO account (accountid,password,salt,status,errorcount,createtime,lastmodifiedtime) "
				+ " VALUES (:accountid,:password,:salt,:status,:errorcount,:createtime,:lastmodifiedtime)";
	
		Map<String, Object> map= new HashMap<>();
		map.put("accountid", account.getAccountid());
		map.put("password",account.getPassword());
		map.put("salt",account.getSalt());
		map.put("status",account.getStatus());
		map.put("errorcount",account.getErrorcount());	
		Date date = new Date();
		map.put("createtime",new Timestamp(date.getTime()));
		map.put("lastmodifiedtime",new Timestamp(date.getTime()));
		
		namedParameterJdbcTemplate.update(sql, map);
	}




}
