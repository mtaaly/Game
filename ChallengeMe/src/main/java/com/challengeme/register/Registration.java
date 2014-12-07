package com.github.user;

/**
 * 
 * Die Klasse Registration speichert halt den name, password und Email
 * 
 * @author Steeve
 * 
 */
public class Registration {

	private  int id;
	private String name;
	private String password;
	private String email;
	
	
	public Registration(String name, String password, String email){
		id++;
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
	}
	
	/*
	 * gibt den Id zurück
	 */
	public int getId() {
		return id;
	}
	/*
	 * setzt ein Nummer für die Id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * gibt den Name zurück
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
	 * gibt den Password zurück
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
	 * gibt den Email zurück
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
