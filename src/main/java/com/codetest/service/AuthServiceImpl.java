package com.codetest.service;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codetest.entity.UserEnt;
import com.codetest.model.User;

@Component
public class AuthServiceImpl implements AuthService{
	
	@Autowired EntityManager em;

	@Override
	public void register(User user) throws NoSuchAlgorithmException {
		UserEnt userEnt = em.find(UserEnt.class, user.getEmail());
		if(userEnt!=null) {
			em.persist(user.toEnt());
		}
	}

	@Override
	public User doAuth(User user) throws NoSuchAlgorithmException {
		UserEnt uEnt = em.find(UserEnt.class, user.getEmail());
		return uEnt!=null&&user.getHashedPassword().equals(uEnt.getHashedPassword()) ?
				user : null;
	}

}
