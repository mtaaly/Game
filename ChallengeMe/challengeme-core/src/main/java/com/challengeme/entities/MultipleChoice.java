package com.challengeme.entities;

import java.util.HashSet;
/**
 * Die Klasse MutlipleChoice speichert halt die Fragen
 * Jede Frage hat eine Liste von Antwort
 * Zwischen diesen Antworten befindet sich die Richtige Antwort
 * Jede Frage muss zu einer Kategorie und zu einem Level zugeordnet werden 
 * @author Steeve
 */
import java.util.Set;

public class MultipleChoice {
	
	/** id von jeder Frage*/
	private int id;
	
	/**Jede Frage muss zu einer Kategorie zugeordnet werden  */
	private Kategorie unterKategorie;
	
	/** Jede Frage muss zu einem Level zugeordnet werden  */
	private Level level;

	/** Attribut die Frage */
	private String question;
	
	/** Jede Frage hat eine Liste von Antwort */
	private Set<Answer> answers = new HashSet<Answer>();
	
	/** Zwischen diesen Antworten befindet sich die Richtige Antwort */
	private Answer correctAnswer;
    
	
	/**
	 * gibt id einer Frage zurück
	 * @return id
	 */
	public int getId() {
		return id;
	}
    
	/**
	 * setzt id einer Frage
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
    
	/**
	 * gibt die kategorie einer Frage zurück  
	 * @return unterkategorie
	 */
	public Kategorie getUnterKategorie() {
		return unterKategorie;
	}
    
	/**
	 * setzt eine Kategorie für eine Frage
	 * @param unterKategorie
	 */
	public void setUnterKategorie(Kategorie unterKategorie) {
		this.unterKategorie = unterKategorie;
	}

	
	/**
	 * gibt die Frage zurück
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
    
	/**
	 * setzt eine Frage
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	} 
    
	/**
	 * gibt eine liste von Antworten im Bezug auf einer Frage
	 * @return answers
	 */
	public Set<Answer> getAnswers() {
		return answers;
	}
    
	/**
	 * setzt eine liste von antworten für eine gegebene Frage
	 * @param answers
	 */
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
    
	/**
	 * gibt die Richtige Antwort zurück
	 * @return correctAnswer
	 */
	public Answer getCorrectAnswer() {
		return correctAnswer;
	}
   
	/**
	 * setzt eine Richtige Antwort für eine Frage
	 * @param correctAnswer
	 */
	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
   
	/**
	 * gibt den Level einer Frage zurück
	 * @return level
	 */
	public Level getLevel() {
		return level;
	}
    
	/**
	 * setzt einen Level für eine Frage
	 * @param level
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

}
