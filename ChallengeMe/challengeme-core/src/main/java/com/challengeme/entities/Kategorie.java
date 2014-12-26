package com.challengeme.entities;

import java.util.HashSet;
import java.util.Set;

public class Kategorie {

	private int kategorieId;
	private String kategorieName;
	private Set<MultipleChoice> multipleChoices = new HashSet<MultipleChoice>();

	public int getKategorieId() {
		return kategorieId;
	}

	public void setKategorieId(int kategorieId) {
		this.kategorieId = kategorieId;
	}

	public String getKategorieName() {
		return kategorieName;
	}

	public void setKategorieName(String kategorieName) {
		this.kategorieName = kategorieName;
	}

	public Set<MultipleChoice> getMultipleChoice() {
		return multipleChoices;
	}

	public void setMultipleChoice(Set<MultipleChoice> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}
}
