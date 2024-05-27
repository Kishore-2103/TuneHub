package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongService;

@Controller
@RequestMapping
public class SongsController {
	@Autowired
	SongService sserv;
	
	
	@PostMapping("addsongs")
	public String addSongs(@ModelAttribute Songs song)
	{
		boolean userstatus=sserv.songExists(song.getName());
		if(userstatus==false) {
		sserv.addSongs(song);
		System.out.println("song added");
		return "songsuccess";
		}
		else
		{
			System.out.println("Song already present try some other songs");
			return "songfail";
		}
		
	}
	
	
	@GetMapping("map-viewsongs")
	public String viewsongs(Model model)
	{  List<Songs> songslist=sserv.getAllSongs();
	model.addAttribute("songslist",songslist );
		return "viewsuccess";
		
	}
	
	@GetMapping("map-viewsongscustomer")
	public String viewsongscustomer(Model model) {
	boolean primeStatus=true;
	if(primeStatus==true)
	{  List<Songs> songslist=sserv.getAllSongs();
	model.addAttribute("songslist",songslist );
		return "viewsuccess";
	}
	else {
		return "makepayment";
	}
	
	} 
}
