package com.tank.challengeme.service;

import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.dao.UserDao;

@Configuration
public class ServiceLocator {
	public ServiceLocator() {
		
	}
	@Bean
	public UserDao getUserService(){
		return new UserDao();
	}
	
	@Bean
	public Session getSession(){
		return HibernateConfigurator.getInstance().getSession();
	}
}
