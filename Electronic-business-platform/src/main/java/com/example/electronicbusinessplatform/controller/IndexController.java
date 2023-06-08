package com.example.electronicbusinessplatform.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electronicbusinessplatform.model.User;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String login(HttpSession session , Model model) {
		String accountid = (String) session.getAttribute("accountid");
		model.addAttribute("accountid", accountid);
		if(accountid != null) {
			return "list";
		}else {
			return "login";
		}
		
		
	}
	
	//@RequestMapping("/register")
	@GetMapping("/register")
	public String register(Model model  ) {

		model.addAttribute("user",new User());
		
		return "register";
	}
}
