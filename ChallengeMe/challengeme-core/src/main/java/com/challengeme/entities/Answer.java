package com.challengeme.entities;

/**
 * Die Klasse Answer speichert halt die Antwort und hat einen Verweis auf die
 * Klasse MultipleChoice
 * 
 * @author Steeve
 */
public class Answer {

	/** id der Table Answer */
	private int id;

	/** Attribut für die Antwort */
	private String answer;

	/** Eine Antwort braucht eine Frage. */
	private MultipleChoice multipleChoice;

	/**
	 * gibt id der Antwort zurück
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * setzt id der Antwort
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * gibt die Antwort zurück
	 * 
	 * @return antwort
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * setzt eine Antwort
	 * 
	 * @param answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * gibt die zugehörige Frage zurück
	 * 
	 * @return multipleChoice
	 */
	public MultipleChoice getMultipleChoice() {
		return multipleChoice;
	}

	/**
	 * setzt eine Frage für eine gegebene Antwort
	 * 
	 * @param multipleChoice
	 */
	public void setMultipleChoice(MultipleChoice multipleChoice) {
		this.multipleChoice = multipleChoice;
	}

}
