package com.challengeme.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.User;


public class UserDao {

	public void insert(String email, String name, String password) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			User reg = new User();
			reg.setEmail(email);
			reg.setName(name);
			reg.setPassword(password);
			session.save(reg);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 

	}
	
	public User insert(String name) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			User reg = new User();
			reg.setName(name);
			session.save(reg);
			tx.commit();
			return reg;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
         return null;
	}
	
	/* Method to DELETE an user from the records */
	public void delete(Integer UserID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
		
		    User del = (User) session.get(User.class, UserID);
			if(del.getSpiel()==null){
				session.delete(del);
			}else{
				del.setSpiel(null);
			}
		    session.delete(del);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
	}
	
	public void update(Integer userID, String email, String name , String password) {
		Session session = HibernateConfigurator.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User upd = (User) session.get(User.class, userID);
			upd.setEmail(email);
			upd.setName(name);
			upd.setPassword(password);
			session.update(upd);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			List<User> users=session.createQuery(" select u from User u ").list();
			return users;
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		return null;
	}
	public void insert(User employee) {
		Session session = HibernateConfigurator.getInstance().getSession();
		Transaction tx = TransaktionContainer.getTransaktion();
		try {
			session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null){
				tx.rollback();
				session.evict(employee);
			}
			e.printStackTrace();
		} 
		
	}
	@SuppressWarnings("unchecked")
	public User findUser(String login, String password) {
		Session session = HibernateConfigurator.getInstance().getSession();
		Transaction tx = TransaktionContainer.getTransaktion();
		try {
			List<User> users = session
					.createQuery(
							"select u from User u where u.email=:login and u.password=:pwd")
					.setParameter("login", login).setParameter("pwd", password)
					.list();
			tx.commit();
			if(users.isEmpty()){
				return null;
			}
			return users.get(0);
		} catch (HibernateException e) {
			if (tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		} 
		return null;
	}

}
