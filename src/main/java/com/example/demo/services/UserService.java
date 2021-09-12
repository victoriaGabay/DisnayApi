package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SendMailServices sendMailServ;
	
	public Users findByUsername(String username) {
		return userRepo.findByUserName(username);
	}

	public Users save(Users user) {
		Users us = userRepo.save(user); 
		sendMailServ.sendEmail(us);
		return us;
	}
	
}
