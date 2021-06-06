package com.codetest.service;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.codetest.entity.UserEnt;
import com.codetest.model.User;

@Component
public class AuthServiceImpl implements AuthService{
	
	@Autowired EntityManager em;

	@Override
	@Transactional
	public User register(User user) throws NoSuchAlgorithmException {
		UserEnt userEnt = em.find(UserEnt.class, user.getEmail());
		
		if(userEnt==null) 
			em.persist(user.toEnt());
		else
			user = null;
		
		return user;
	}

	@Override
	public User doAuth(User user) throws NoSuchAlgorithmException {
		UserEnt uEnt = em.find(UserEnt.class, user.getEmail());
		SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
		User u = uEnt!=null&&sCryptPasswordEncoder
				.matches(user.getSuppliedPassword(), uEnt.getHashedPassword()) 
				? user : null;
		return u;
	}

}
