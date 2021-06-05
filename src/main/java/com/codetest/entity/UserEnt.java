package com.codetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class UserEnt {
	
	@Id
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="HASHED_PASSWORD")
	private String hashedPassword;
	
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
