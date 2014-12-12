package com.tank.challengeme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	private ServiceLocator services;

	public void insert(String email, String name, String password) {
		services.getUserService().insert(email,name,password);
		
	}

}
