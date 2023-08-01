package com.example.demo;

public class Question {

	private int id;
	private String text;
	private String correctAnswer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public Question(int id, String text, String correctAnswer) {
		super();
		this.id = id;
		this.text = text;
		this.correctAnswer = correctAnswer;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", correctAnswer=" + correctAnswer + "]";
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
