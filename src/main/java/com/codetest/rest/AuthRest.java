package com.codetest.rest;

import java.security.NoSuchAlgorithmException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.model.User;
import com.codetest.service.AuthService;

@RestController
@RequestMapping("authrest")
public class AuthRest {
	
	@Autowired
	AuthService authService;
	
	@PostMapping(path="/register", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public User registerUser(@RequestBody User user) {
		try {
			user = authService.register(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	@PostMapping(path="/login", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public User authen(@RequestBody User user) {
		try {
			return authService.doAuth(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} 
	}

}
