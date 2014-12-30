package com.challengeme.entities;

import javax.persistence.Transient;

/**
 * 
 * Die Klasse User speichert speichert wichtige Infos
 * �ber den Spieler
 * sowie die Anzahl der Punkten, die er im Spiel erwoben hat.
 * @author Steeve
 * 
 */
public class User {
    
	/** id der User */
	private  int id;
	 
	/** name der User */
	private String name;
	
	/** password der User */
	private String password;
	
	/** email der User */
	private String email;
	
	/** speichert Spiel */
	private Spiel spiel;
	
	/** anzahl der punkte der User */
	private int counter;
	
	/**
	 * gibt Id  des Users zur�ck
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * setzt Id f�r User.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * gibt den Name zur�ck
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setzt einen Name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * gibt den Password zur�ck
	 * @return password
	 */
	@Transient
	public String getPassword() {
		return password;
	}
	
	/**
	 * setzt einen Password.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * gibt den Email zur�ck
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * setzt eine Email adresse.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * gibt anzahl der punkten zur�ck
	 * @return counter
	 */
	public int getCounter() {
		return counter;
	}
	
	/**
	 * setzt die Anzah der Punkte
	 * @param counter
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	/**
	 * gibt den Spiel zur�ck 
	 * @return spiel
	 */
	public Spiel getSpiel() {
		return spiel;
	}
	
	/**
	 * setzt ein Spiel
	 * @param spiel
	 */
	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}
	
}
