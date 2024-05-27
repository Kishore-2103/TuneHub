package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongService;

@Controller
@RequestMapping
public class NavController {
	@Autowired
	SongService sserv;
	
	@GetMapping("map-register")
	public String reg()
	{
		return "register";
		
	}
	
	@GetMapping("map-login")
	public String log()
	{
		return "login";
		
	}
	
	@GetMapping("map-songs")
	public String addsongs()
	{
		return "addsongs";
		
	}
	
	

}
