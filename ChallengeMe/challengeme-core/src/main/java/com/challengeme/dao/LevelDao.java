package com.challengeme.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.Kategorie;
import com.challengeme.entities.Level;

public class LevelDao {
	
	//private static int count = 0; 
	
public Level insert(String levelName, Kategorie... kategories)  {
		

		//TODO response muss be in answer array
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			Level reg = new Level();
			reg.setLevelName(levelName);
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
	
	// Method to DELETE a level from the records 
	public void delete(Integer levelID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
		
			Level del = (Level) session.get(Level.class, levelID);
			session.delete(del);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
	}
	
	 //Method to update a question from the records 
	public void updateLevel(Integer levelID, String levelName) {
		
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		
		try {
			
			Level upd = (Level) session.get(Level.class, levelID);
			upd.setLevelName(levelName);
			session.update(upd);
			tx.commit();
		} catch (HibernateException e) {
		
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Level> getLevels(){
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			List<Level> levels = session.createQuery(" select l from Level l ").list();
			return levels;
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		return null;
	}


}
