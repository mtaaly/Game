package com.challengeme.entities;

import java.util.HashSet;
import java.util.Set;

public class Level {
	private int LevelId;
	private String levelName;
	private Set<Kategorie> kategories = new HashSet<Kategorie>();
	
	
	public int getLevelId() {
		return LevelId;
	}
	public void setLevelId(int levelId) {
		LevelId = levelId;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Set<Kategorie> getKategories() {
		return kategories;
	}
	public void setKategories(Set<Kategorie> kategories) {
		this.kategories = kategories;
	}

}
