package com.challengeme.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Die Klasse Spiel hat eine Liste von Levels und eine Liste Von Users. (Der
 * Spiel fängt ab hier an.)
 * 
 * @author Steeve
 * 
 */
public class Spiel {

	/** id des Spieles */
	private int id;

	/** liste von levels */
	private Set<Level> levels = new HashSet<Level>();

	/** liste von Users */
	private Set<User> users = new HashSet<User>();

	/** All getter und setter Methoden */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Level> getLevels() {
		return levels;
	}

	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
