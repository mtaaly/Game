package com.challengeme.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challengeme.config.HibernateConfigurator;
import com.challengeme.config.TransaktionContainer;
import com.challengeme.entities.Answer;
import com.challengeme.entities.Kategorie;
import com.challengeme.entities.Level;
import com.challengeme.entities.MultipleChoice;

public class LevelDao {

	/**
	 * fügt liste von fragen in einem level ein
	 * 
	 * @param levelName
	 * @param multiplechoices
	 * @return
	 */
	public Level insert(String levelName, MultipleChoice... multiplechoices) {

		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			Level reg = new Level();
			reg.setLevelName(levelName);
			for (MultipleChoice m : multiplechoices) {
				m.setLevel(reg);
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

	// Method to DELETE a level from the records
	public void delete(Integer levelID) {
		Transaction tx = TransaktionContainer.getTransaktion();
		Session session = HibernateConfigurator.getInstance().getSession();

		try {
			Level del = (Level) session.get(Level.class, levelID);
			if (del.getMultipleChoices() == null) {
				session.delete(del);
			} else {
				for (MultipleChoice c : del.getMultipleChoices()) {
					c.setLevel(null);
				}
				del.setMultipleChoices(null);
				del.setSpiel(null);

				session.delete(del);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	/** Method to update a level from the records */
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
    
	/** method to get all level im spiel */
	@SuppressWarnings("unchecked")
	public List<Level> getLevels() {
		Session session = HibernateConfigurator.getInstance().getSession();
		try {
			List<Level> levels = session.createQuery(" select l from Level l ")
					.list();
			return levels;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
