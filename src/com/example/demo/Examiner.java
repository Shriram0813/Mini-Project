package com.example.demo;

import java.util.List;

public class Examiner {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Examiner [id=" + id + ", name=" + name + "]";
	}
	public Examiner(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
