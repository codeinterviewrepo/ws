package com.codetest.rest;

import java.security.NoSuchAlgorithmException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.model.User;
import com.codetest.service.AuthService;

@RestController
@RequestMapping("authrest")
public class AuthRest {
	
	@Autowired
	AuthService authService;
	
	@PostMapping(path="/register", produces = "application/json")
	public User registerUser(User user) {
		try {
			authService.register(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return user;
		}
		return user;
	}
	
	@PostMapping(path="/authenticate", produces = "application/json")
	public User authenticate(User user) {
		try {
			return authService.doAuth(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} 
	}

}
