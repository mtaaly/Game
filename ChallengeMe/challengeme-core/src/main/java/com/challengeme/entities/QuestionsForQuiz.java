package com.challengeme.entities;

/**
 * Diese Klasse speichert Fragen. Aber da habe ich mir gedacht, dass der User
 * die Anwort selbst angeben muss.
 * 
 * @author Steeve
 * 
 */
public class QuestionsForQuiz {

	/** id der frage */
	private int id;

	/** Attribut für die Frage */
	private String question;

	/** Alle getter und Setter Methoden */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
