package com.challengeme.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.Kategorie;
import com.challengeme.entities.MultipleChoice;

public class KategorieDao {
	
	/* Method to insert a question to the records */
	public Kategorie insert(String kategorieName,MultipleChoice... multipleChoices) {
		
		//TODO response muss be in answer array
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			Kategorie reg = new Kategorie();
			reg.setKategorieName(kategorieName);
			for(MultipleChoice m : multipleChoices){
				m.setKategorie(reg);
			   	reg.getMultipleChoices().add(m);
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
	
public void insert(String kategorieName) {
		
		//TODO response muss be in answer array
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			Kategorie reg = new Kategorie();
			reg.setKategorieName(kategorieName);
			session.save(reg);
			tx.commit();
		
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
        
	}

	
	// Method to DELETE a question from the records 
	public void delete(Integer kategorieID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
		
			Kategorie del = (Kategorie) session.get(Kategorie.class, kategorieID);
			session.delete(del);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
	}
	
	 //Method to update a question from the records 
	public void updateKategorie(Integer kategorieID, String kategorieName) {
		
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		
		try {
			
			Kategorie upd = (Kategorie) session.get(Kategorie.class, kategorieID);
			upd.setKategorieName(kategorieName);
			session.update(upd);
			tx.commit();
		} catch (HibernateException e) {
		
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Kategorie> getAllKategories(){
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			List<Kategorie> kategories = session.createQuery(" select k from Kategorie k ").list();
			return kategories;
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		return null;
	}


}
