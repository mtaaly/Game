package com.challengeme.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.QuestionsForQuiz;




public class QuestionsForQuizDao {
	
	/* Method to insert a question to the records */
	public void insert(String question) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			QuestionsForQuiz reg = new QuestionsForQuiz();
			reg.setQuestion(question);
			session.save(reg);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 

	}
	
	/* Method to DELETE a question from the records */
	public void delete(Integer questionID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
		
			QuestionsForQuiz del = (QuestionsForQuiz) session.get(QuestionsForQuiz.class, questionID);
			session.delete(del);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} 
	}
	
	/* Method to update a question from the records */
	public void updateQuestion(Integer questionID, String question) {
		
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		
		try {
			
			QuestionsForQuiz upd = (QuestionsForQuiz) session.get(QuestionsForQuiz.class, questionID);
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
	public List<QuestionsForQuiz> getAllQuestions(){
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			List<QuestionsForQuiz> questions = session.createQuery(" select q from QuestionsForUser u ").list();
			return questions;
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		return null;
	}

}
