package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UserService {
	public String register(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email, String password);
	public String getRole(String email);



}
