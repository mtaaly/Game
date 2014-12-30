package com.challengeme.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.Level;
import com.challengeme.entities.Spiel;
import com.challengeme.entities.User;

public class SpielDao {

	public Spiel insert(Set<Level> levels, Set<User> users) {

		// TODO response muss be in answer array
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			Spiel reg = new Spiel();

			for (Level l : levels) {
				l.setSpiel(reg);
				reg.getLevels().add(l);
				session.save(l);
			}
			for (User u : users) {
				u.setSpiel(reg);
				reg.getUsers().add(u);
				session.save(u);
			}

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

	public Spiel createSpiel() {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			Spiel reg = new Spiel();
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

	public Spiel insertUserInSpiel(Spiel spiel, User user) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			if(spiel.getUsers().contains(user)){
				return spiel;
			}else{
				spiel.getUsers().add(user);
			}
			session.save(spiel);
			tx.commit();
			return spiel;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public Spiel getAllLevelInSpiel(){
		
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			Spiel spiel= createSpiel();
			spiel.getLevels();
			session.save(spiel);
			tx.commit();
			return spiel;
		
		}catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return null;
		
		
	}

	// Method to DELETE a level from the records
	public void delete(Integer spielID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();

		try {
			Spiel del = (Spiel) session.get(Spiel.class, spielID);
			if (del.getLevels() == null && del.getUsers() == null) {
				session.delete(del);
			} else {
				for (Level l : del.getLevels()) {
					l.setSpiel(null);
				}
				for (User u : del.getUsers()) {
					u.setSpiel(null);
				}
				del.setUsers(null);
				del.setLevels(null);
				session.delete(del);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

}
