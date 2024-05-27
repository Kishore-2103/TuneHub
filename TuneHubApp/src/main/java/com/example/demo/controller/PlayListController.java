package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping
public class PlayListController {
	
	@Autowired
	SongService sserv;
	
	@Autowired
	PlayListService pserv;
	
	@GetMapping("/map-createPlaylist")
	public String createPlaylist(Model model) {
		List<Songs> songslist=sserv.getAllSongs();
		model.addAttribute("songslist",songslist );
			return "createplaylist";
	}
	
	@PostMapping("add-playlist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		
		
		return "playlistsuccess";
	}
	
	

}
