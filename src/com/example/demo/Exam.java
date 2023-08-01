package com.example.demo;

import java.util.List;

public class Exam {

	private int id;
	private String title;
	private List <Question> question;
	public Exam(int id, String title, List<Question> question) {
		super();
		this.id = id;
		this.title = title;
		this.question = question;
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", title=" + title + ", question=" + question + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(List<Question> question) {
		this.question = question;
	}
}
