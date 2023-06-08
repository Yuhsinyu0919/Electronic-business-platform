package com.example.electronicbusinessplatform.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.electronicbusinessplatform.model.Account;
import com.example.electronicbusinessplatform.service.AccountService;

@RestController
public class loginController {

	@Autowired
	private AccountService accountService;
	
	/*
	@RequestMapping("/login/{accountid}")
	public ResponseEntity<Account> login(@PathVariable String accountid) {
		Account account = accountService.getAccountById(accountid);
		return ResponseEntity.status(HttpStatus.OK).body(account);
	}
	*/
	
	@RequestMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Account account ,  HttpSession session) { //public ResponseEntity<Account> login(@RequestBody Account account ) {
		System.out.println("account.getAccountid()"+account.getAccountid());
		System.out.println("account.getPassword()"+account.getPassword());
		
		boolean result = accountService.getAccount(account.getAccountid(), account.getPassword());
		System.out.println("result="+result);
		
	    Map<String, Object> response = new HashMap<>();
	    response.put("success", result);
	    if (result) {
	    	response.put("message", "登入成功");
	    	session.setAttribute("accountid", account.getAccountid());
	    }else {

	    	response.put("message", "登入失敗");
	    }

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@RequestMapping("/logout")
	public ResponseEntity<Map<String, Object>> logout( HttpSession session) { 
		session.setAttribute("accountid", null);
		
	    Map<String, Object> response = new HashMap<>();
	    response.put("success", true);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Account> insertAccount(@RequestBody Account account){

		accountService.insertAccount(account);
		return ResponseEntity.status(HttpStatus.OK).body(account);
	}
	
}
