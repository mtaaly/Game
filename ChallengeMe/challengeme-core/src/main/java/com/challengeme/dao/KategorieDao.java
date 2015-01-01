package com.challengeme.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.Kategorie;
import com.challengeme.entities.MultipleChoice;

public class KategorieDao {

/**
 * Ordnet eine unterkategorie zu einer kategorie
 * @param kName
 * @param unterKategories
 * @return oberkategorie
 */
public Kategorie createKategorie(String kName, Set<Kategorie> unterKategories) {
	
	Transaction tx = TransaktionContainer.getTransaktion();
	Session session = HibernateConfigurator.getInstance().getSession();
	try {
		
		
		
		Kategorie oberKategorie = new Kategorie();
		oberKategorie.setKategorieName(kName);
		for(Kategorie k: unterKategories){
			if(k.getOberKategorie()!=null){
				continue;
			}
			k.setOberKategorie(oberKategorie);
			oberKategorie.getUnterKategories().add(k);
			session.saveOrUpdate(k);
		}
		
		session.save(oberKategorie);
		tx.commit();
		return oberKategorie;
	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} 
	return null;
}

   /**
    * fügt ein MultipleChoice zu einer UnterKategorie ein.
    * @param unterKategorie
    * @param multiplechoices
    * @return
    */
public Kategorie insert(Kategorie unterKategorie, MultipleChoice... multiplechoices)  {
	

	
	Transaction tx = TransaktionContainer.getTransaktion();
	Session session = HibernateConfigurator.getInstance().getSession();
	try {
		for(MultipleChoice m : multiplechoices){
		  //setzt unterkategorie zu m.
			m.setUnterKategorie(unterKategorie);
		  // fügt m zu unterkategorie ein 	
			unterKategorie.getMultipleChoices().add(m);
		}
		session.save(unterKategorie);
		tx.commit();
		return unterKategorie;
	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	}
	return null; 
}
	
	// Method to DELETE a kategorie from the records 
	public void delete(Integer kategorieID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
		
			Kategorie del = (Kategorie) session.get(Kategorie.class, kategorieID);
			//wenn die kategorie keine Fragen enthält
			//dann lösche einfach die kategorie
			if(del.getMultipleChoices()==null){
				session.delete(del);
			}else{
			// sonst setze die kategorie von jede
			// frage auf null
				for(MultipleChoice m : del.getMultipleChoices()){
					m.setUnterKategorie(null);
				}
				del.setMultipleChoices(null);
				session.delete(del);
			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
	}
	
	 //Method to update a kategorie from the records 
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
