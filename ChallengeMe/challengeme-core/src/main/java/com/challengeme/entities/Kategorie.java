package com.challengeme.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Es ist wichtig, dass jede Frage in einer Kategorie zugeordnet wird. Die
 * Klasse Kategorie tut das und Speichert auch Unterkategories
 * 
 * @author Steeve
 */
public class Kategorie {

	/** id der Table Kategorie */
	private int kategorieId;

	/** Name der Kategorie */
	private String kategorieName;

	/**
	 * Eine Kategorie kann in einer anderen Kategorie zugeordnet werden Deswegen
	 * braucht man eine oberkategorie und eine List von unterkategories.
	 * */
	private Kategorie oberKategorie;
	private Set<Kategorie> unterKategories = new HashSet<Kategorie>();

	/** Jede Kategorie enthält viele MultipleChoice */
	private Set<MultipleChoice> multipleChoices = new HashSet<MultipleChoice>();

	/**
	 * gibt id zurück
	 * 
	 * @return id
	 */
	public int getKategorieId() {
		return kategorieId;
	}

	/**
	 * setzt id der kategorie
	 * 
	 * @param kategorieId
	 */
	public void setKategorieId(int kategorieId) {
		this.kategorieId = kategorieId;
	}

	/**
	 * gibt den name der Kategorie zurück
	 * 
	 * @return kategorieName
	 */
	public String getKategorieName() {
		return kategorieName;
	}

	/**
	 * setzt einen name für die Kategorie
	 * 
	 * @param kategorieName
	 */
	public void setKategorieName(String kategorieName) {
		this.kategorieName = kategorieName;
	}

	/**
	 * gibt eine liste von Fragen zurück
	 * 
	 * @return multipleChoices
	 */
	public Set<MultipleChoice> getMultipleChoices() {
		return multipleChoices;
	}

	/**
	 * setzt eine liste von Fragen
	 * 
	 * @param multipleChoices
	 */
	public void setMultipleChoices(Set<MultipleChoice> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}

	/**
	 * gibt eine Liste von unterkategories zurück
	 * 
	 * @return unterkategories
	 */
	public Set<Kategorie> getUnterKategories() {
		return unterKategories;
	}

	/**
	 * setzt eine Liste von unterkategories
	 * 
	 * @param unterKategories
	 */
	public void setUnterKategories(Set<Kategorie> unterKategories) {
		this.unterKategories = unterKategories;
	}

	/**
	 * gibt eine oberkategorie zurück
	 * 
	 * @return oberkategorie
	 */
	public Kategorie getOberKategorie() {
		return oberKategorie;
	}

	/**
	 * setzt eine oberkategorie
	 * 
	 * @param kategorie
	 */
	public void setOberKategorie(Kategorie kategorie) {
		this.oberKategorie = kategorie;
	}
}
