package com.codetest.service;

import java.security.NoSuchAlgorithmException;

import com.codetest.model.User;

public interface AuthService {
	
	public void register(User user) throws NoSuchAlgorithmException;

	User doAuth(User user) throws NoSuchAlgorithmException;

}
