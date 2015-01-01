package com.challengeme.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.Answer;
import com.challengeme.entities.MultipleChoice;

public class MultipleChoiceDao {

	/** Method to insert a question to the records */
	public MultipleChoice insert(String question, Answer response,
			Answer... answers) {
		if (response == null || answers == null) {
			return null;
		}
		
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			MultipleChoice reg = new MultipleChoice();
			reg.setQuestion(question);
			for (Answer a : answers) {
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

	/** Method to DELETE a question from the records */
	public void delete(Integer questionID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			MultipleChoice del = (MultipleChoice) session.get(
					MultipleChoice.class, questionID);
			if (del.getAnswers() == null && del.getCorrectAnswer() == null) {
				session.delete(del);
			} else {
				//coupe les liens avec dautres classes
				del.getLevel().getMultipleChoices().remove(del);
				del.setLevel(null);
				del.getUnterKategorie().getMultipleChoices().remove(del);
				del.setUnterKategorie(null);
			    Answer correctAnswer = del.getCorrectAnswer();
			    correctAnswer.setMultipleChoice(null);
				del.setCorrectAnswer(null);
				for (Iterator<Answer> iters = del.getAnswers().iterator(); iters
						.hasNext();) {
					Answer a = iters.next();
					a.setMultipleChoice(null);
					iters.remove();
					session.delete(a);
				}
				session.delete(del);
			}
			
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	// Method to update a question from the records
	public void updateQuestion(Integer questionID, String question) {

		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();

		try {

			MultipleChoice upd = (MultipleChoice) session.get(
					MultipleChoice.class, questionID);
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
	public List<MultipleChoice> getAllMultipleChoice() {
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			List<MultipleChoice> questions = session.createQuery(
					" select m from MutlipleChoice m ").list();
			return questions;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
