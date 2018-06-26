package com.ust.poc.pmain.dao;

import java.util.List;

import com.mongodb.DBObject;
import com.ust.poc.pmain.model.Pmodel;

public interface Pdao {

	public String addP(Pmodel pmodel);

	public List<DBObject> diplayPersons();

	public String getPerson(int id);

	public String deletePer(int id);

	public String updatePer(Pmodel pmodel);

	public String addservice();

}
