package com.example.webtoken.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webtoken.model.User;
import com.example.webtoken.repository.UserRepositoryJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping(value = "/cachedemo/v1/users")
public class UserController {

	@Autowired
	private UserRepositoryJPA userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(UserRepositoryJPA userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void signUp(@RequestBody User user) {
		if(user == null || user.getUsername() == null || user.getUsername().equals("") || user.getPassword() == null || user.getPassword().contentEquals("")) {
			System.out.println("Invalid User. Can't signUp.");
			return;
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		System.out.println("User added successfully.");
	}
}
