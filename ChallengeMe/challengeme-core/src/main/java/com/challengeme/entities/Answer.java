package com.challengeme.entities;

public class Answer {
	private int id;
	private String answer;
    private MultipleChoice multipleChoice;
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public MultipleChoice getMultipleChoice() {
		return multipleChoice;
	}

	public void setMultipleChoice(MultipleChoice multipleChoice) {
		this.multipleChoice = multipleChoice;
	}

}
