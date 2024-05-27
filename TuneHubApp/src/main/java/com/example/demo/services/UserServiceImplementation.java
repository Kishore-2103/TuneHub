package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
	UserRepository urepo;
    
    
	@Override
	public String register(Users user) {
		urepo.save(user);
		return "user created";
	}


	@Override
	public boolean emailExists(String email) {
		if(urepo.findByEmail(email)== null)
		{
		return false;
		}
		else {
			return true;
		}
	}


	@Override
	public boolean validateUser(String email, String password) {
		Users user=urepo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(password))
		{
			return true;
		}
		else
		{
		return false;
		}

	}


	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		return (urepo.findByEmail(email).getRole());

	}


	
	

}
