package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UserService;

@Controller
@RequestMapping
public class UsersController {
	@Autowired
	UserService userv;
	
	
	
	@PostMapping("reg")	
	public String registerModule(@ModelAttribute Users user) {
		boolean userstatus=userv.emailExists(user.getEmail());
		if(userstatus==false) {
		userv.register(user);
		System.out.println("user added");
		return "registersuccess";
		}
		else {
			System.out.println("user already exists");
			return "registerfail";
		}
		
	}
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password)
	{
		//boolean loginstatus=userv.validateUser(email, password);
		if(userv.validateUser(email, password)==true)
		{
			if(userv.getRole(email).equals("Admin"))
			{
			return "adminhome";
			}
			else
			{
				return "customerhome";
			}
		}
		else
		{
			
			return "loginfail";
		}
	}
}