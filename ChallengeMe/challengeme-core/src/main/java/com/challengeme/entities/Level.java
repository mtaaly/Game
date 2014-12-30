package com.challengeme.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Jede Frage soll zu einem Level zugeordnet werden und jeder Level hat einen
 * Verweis auf einem Spiel
 * 
 * @author Steeve
 * 
 */
public class Level {

	/** id der Level */
	private int LevelId;

	/** Name der Level */
	private String levelName;

	/** zu jedem Level geh�rt eine liste von MultipleChoice */
	private Set<MultipleChoice> multipleChoices = new HashSet<MultipleChoice>();

	/** Ein Level wird zu einem Spiel zugeordnet */
	private Spiel spiel;

	/** gibt den Id des Levels zur�ck */
	public int getLevelId() {
		return LevelId;
	}

	/** setzt einen Id f�r den Level */
	public void setLevelId(int levelId) {
		LevelId = levelId;
	}

	/**
	 * gibt den Name des Levels zur�ck
	 * 
	 * @return levelName
	 * */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * setzt einen Name f�r den Level
	 * 
	 * @param levelName
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	/**
	 * gibt eine liste von Fragen zur�ck
	 * 
	 * @return multipleChoices
	 */
	public Set<MultipleChoice> getMultipleChoices() {
		return multipleChoices;
	}

	/**
	 * setzt eine Liste von fragen
	 * 
	 * @param multipleChoices
	 */
	public void setMultipleChoices(Set<MultipleChoice> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}

	/**
	 * gibt ein Spiel zur�ck
	 * 
	 * @return spiel
	 */
	public Spiel getSpiel() {
		return spiel;
	}

	/**
	 * setzt ein Spiel
	 * 
	 * @param spiel
	 */
	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}

}
