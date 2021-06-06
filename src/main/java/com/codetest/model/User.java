package com.codetest.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import com.codetest.entity.UserEnt;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("password")
	private String suppliedPassword;
	
	@JsonProperty("email")
	private String email;
	
	public String getSuppliedPassword() {
		return this.suppliedPassword;
	}
	
	public void setSuppliedPassword(String suppliedPassword) {
		this.suppliedPassword = suppliedPassword;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHashedPassword() {
		SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
		return sCryptPasswordEncoder.encode(this.suppliedPassword);
	}
	
	public UserEnt toEnt() throws NoSuchAlgorithmException {
		UserEnt uEnt = new UserEnt();
		uEnt.setEmail(this.email);
		uEnt.setHashedPassword(getHashedPassword());
		return uEnt;
	}

}
