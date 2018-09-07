package com.ust.poc.pmain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
//rule
@Document(collection = "pmodel")
public class Pmodel {

	@Id
	int id;
	String name;
	int age;
	String place;
	String job;

	public Pmodel(int id, String name, int age, String place, String job) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.place = place;
		this.job = job;
	}

	public Pmodel() {
		super();
	}

	public Pmodel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
