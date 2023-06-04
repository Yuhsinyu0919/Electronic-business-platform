package com.example.electronicbusinessplatform.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
