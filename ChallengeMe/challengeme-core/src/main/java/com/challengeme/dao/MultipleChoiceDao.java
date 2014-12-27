package com.challengeme.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.Answer;
import com.challengeme.entities.MultipleChoice;


public class MultipleChoiceDao {
	
	/* Method to insert a question to the records */
	public MultipleChoice insert(String question,Answer response,Answer... answers) {
		if(response==null || answers==null){
			return null;
		}
		//TODO response muss be in answer array
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			MultipleChoice reg = new MultipleChoice();
			reg.setQuestion(question);
			for(Answer a : answers){
				a.setMultipleChoice(reg);
			   	reg.getAnswers().add(a);
			  
			}
			reg.setCorrectAnswer(response);
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

	
	// Method to DELETE a question from the records 
	public void delete(Integer questionID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
		
			MultipleChoice del = (MultipleChoice) session.get(MultipleChoice.class, questionID);
			session.delete(del);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
	}
	
	 //Method to update a question from the records 
	public void updateQuestion(Integer questionID, String question) {
		
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		
		try {
			
			MultipleChoice upd = (MultipleChoice) session.get(MultipleChoice.class, questionID);
			upd.setQuestion(question);
			session.update(upd);
			tx.commit();
		} catch (HibernateException e) {
		
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<MultipleChoice> getAllMultipleChoice(){
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			List<MultipleChoice> questions = session.createQuery(" select m from MutlipleChoice m ").list();
			return questions;
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		return null;
	}


}
