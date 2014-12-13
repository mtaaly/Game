package com.tank.challengeme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challengeme.entities.User;

@Component
public class UserService {
	@Autowired
	private ServiceLocator services;

	public void insert(String email, String name, String password) {
		services.getUserService().insert(email,name,password);
		
	}
	public List<User> getUserListe() {
		return services.getUserService().getAllUsers();
		
	}

}
