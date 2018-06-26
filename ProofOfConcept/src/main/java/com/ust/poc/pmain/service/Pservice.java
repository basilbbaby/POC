package com.ust.poc.pmain.service;

import java.util.List;

import com.mongodb.DBObject;
import com.ust.poc.pmain.model.Pmodel;

public interface Pservice {

	public String addPerson(Pmodel pmodel);

	public List<DBObject> displayAll();

	public String getperson(int id);

	public String deleteP(int id);

	public String updateP(Pmodel pmodel);

	public String addadd();

}
