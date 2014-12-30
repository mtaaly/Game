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

	/** Attribut f�r die Antwort */
	private String answer;

	/** Eine Antwort braucht eine Frage. */
	private MultipleChoice multipleChoice;

	/**
	 * gibt id der Antwort zur�ck
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
	 * gibt die Antwort zur�ck
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
	 * gibt die zugeh�rige Frage zur�ck
	 * 
	 * @return multipleChoice
	 */
	public MultipleChoice getMultipleChoice() {
		return multipleChoice;
	}

	/**
	 * setzt eine Frage f�r eine gegebene Antwort
	 * 
	 * @param multipleChoice
	 */
	public void setMultipleChoice(MultipleChoice multipleChoice) {
		this.multipleChoice = multipleChoice;
	}

}
