package com.codetest.rest;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.codetest.model.User;
import com.codetest.service.AuthService;

@Component
@Path("authrest")
public class AuthRest {
	
	@Autowired
	AuthService authService;
	
	@POST
	@Path("/register")
	public Response registerUser(User user) {
		try {
			authService.register(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.ok().build();
	}
	
	@POST
	@Path("/authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	public User authenticate(User user) {
		try {
			return authService.doAuth(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} 
	}

}
