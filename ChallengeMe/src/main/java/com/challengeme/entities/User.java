package com.challengeme.entities;

/**
 * 
 * Die Klasse Registration speichert halt den name, password und Email
 * 
 * @author Steeve
 * 
 */
public class User {

	private  int id;
	private String name;
	private String password;
	private String email;
	
	/*
	 * gibt den Id zur�ck
	 */
	public int getId() {
		return id;
	}
	/*
	 * setzt ein Nummer f�r die Id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * gibt den Name zur�ck
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * setzt einen Name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * gibt den Password zur�ck
	 */
	public String getPassword() {
		return password;
	}
	
	/*
	 * setzt einen Password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * gibt den Email zur�ck
	 */
	public String getEmail() {
		return email;
	}
	
	/*
	 * setzt eine Email adresse.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
