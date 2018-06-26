package com.ust.poc.pmain.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBObject;
import com.ust.poc.pmain.model.Pmodel;
import com.ust.poc.pmain.service.Pservice;

@RestController
public class Pcontroller {

	@Autowired
	Pservice pservice;

	// ---------------------------------For testing
	// purpose----------------------------------------------

	@RequestMapping("welcome")
	@GetMapping
	public String Welcome() {
		return "Welcome to the program";
	}

	@RequestMapping("name/{name}")
	@GetMapping
	public String printName(@PathVariable String name) {

		return "welcome " + name + "";
	}

	@RequestMapping("name/{name}/age/{age}")
	public String printInfo(@PathVariable String name, @PathVariable int age) {
		return "Welcome " + name + " having age of " + age + "";
	}

	@RequestMapping("name")
	@GetMapping
	public String getName(@RequestBody String name) {
		return " " + name + " welcome! ";
	}

	// --------------------------------------------------------------------------------------------------

	@RequestMapping("insert")
	@PostMapping
	public String getdetails(@RequestBody Pmodel pmodel) {
		return pservice.addPerson(pmodel);

	}
	@RequestMapping("ins")
	@PostMapping
	public String addinsert()
	{
	  return	pservice.addadd();
	
	}

	@RequestMapping(value = "display")
	@GetMapping
	public List<DBObject> displayDetails() {
		return pservice.displayAll();
	}

	@RequestMapping("search")
	@PostMapping
	public String getPerson(@RequestBody int id) {

		return pservice.getperson(id);
	}

	@RequestMapping("delete")
	@PostMapping
	public String deletePerson(@RequestBody int id) {
		return pservice.deleteP(id);
	}

	@RequestMapping("update")
	@PostMapping
	public String updatePerson(@RequestBody Pmodel pmodel) {
		return pservice.updateP(pmodel);
	}
}
