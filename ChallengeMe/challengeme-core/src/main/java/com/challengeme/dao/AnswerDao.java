package com.challengeme.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.Answer;


public class AnswerDao {
 
	
	/** Method to insert a answer to the records */
	public Answer insert(String answer) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			//TODO check duplicate answer
			Answer reg = new Answer();
			reg.setAnswer(answer);
			session.save(reg);
//			session.flush();
			tx.commit();
			return reg;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
       return null;
	}
	
	/** Method to DELETE a answer from the records */
	public void delete(Integer answerID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
		
			Answer del = (Answer) session.get(Answer.class, answerID);
			if(del.getMultipleChoice()==null){
				session.delete(del);
			}else{
				del.setMultipleChoice(null);
				session.delete(del);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
	}
	
	/** Method to update a answer from the records */ 
	public void update(Integer answerID, String answer) {
		
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		
		try {
			
			Answer upd = (Answer) session.get(Answer.class, answerID);
			upd.setAnswer(answer);
			session.update(upd);
			tx.commit();
		} catch (HibernateException e) {
		
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Answer> getAllAnswers(){
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			List<Answer> answers = session.createQuery(" select a from Answer a ").list();
			return answers;
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
