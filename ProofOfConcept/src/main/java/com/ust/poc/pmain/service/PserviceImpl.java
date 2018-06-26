package com.ust.poc.pmain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.ust.poc.pmain.dao.Pdao;
import com.ust.poc.pmain.model.Pmodel;

@Service
public class PserviceImpl implements Pservice {

	@Autowired
	Pdao pdao;

	@Override
	public String addPerson(Pmodel pmodel) {
		return pdao.addP(pmodel);

	}

	@Override
	public List<DBObject> displayAll() {
		return pdao.diplayPersons();
	}

	@Override
	public String getperson(int id) {
		return pdao.getPerson(id);
	}

	@Override
	public String deleteP(int id) {
		return pdao.deletePer(id);
	}

	@Override
	public String updateP(Pmodel pmodel) {
		return pdao.updatePer(pmodel);
	}

	@Override
	public String addadd() {
	
		return pdao.addservice();
	}

}
